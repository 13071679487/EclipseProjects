var status = -1;
function getOrderList(pn,size,status,no){
	currentPage = pn;
	$.ajax({
		url:remotePath+'/manage/order/list',
		type:"GET",
		data:{"pn":pn,"size":size,"orderStatus":status,"orderNo":no},
		success:function(result){
			if(result.code == 100){
				//TODO 获取数据成功
				buildOrderList(result.data);
				buildPageNav(result.data);
			}else{
				layer.msg(result.msg)
			}
		},
		error:function(){
			layer.msg('网络连接失败')
		}
	})
}


/**
 * 构建订单列表
 * @param data
 */
function buildOrderList(data){
	$("#category_table tbody").empty();
	$.each(data.list,function(index,order){
		var tdOrderNo=$("<td></td>").append(order.orderNo)
		var tdCustomerId=$("<td></td>").append(order.receiverName)
		var tdPhone=$("<td></td>").append(order.shippingVo.receiverMobile)
		var tdPayment=$("<td></td>").append(order.payment)
		var tdStatus=$("<td></td>").append("<span class='layui-badge layui-bg-green'>"+order.statusDesc+"</span>")
		var tdCreateTime= $("<td></td>").append(order.createTime)
		var btnSendout=$("<span></span>").addClass('layui-badge layui-bg-green btnSendout').append('发货').prop('style','point:cursor;').attr("orderNo",order.orderNo);
		var btnDetail=$("<span></span>").addClass('layui-badge layui-bg-green btnDetail').append('详情').prop('style','point:cursor;margin-left:2px;').attr("orderNo",order.orderNo);
		var tdOperation=$("<td></td>").append(btnSendout).append(btnDetail);
		var tr=$("<tr></tr>").append(tdOrderNo)
												.append(tdCustomerId)
												.append(tdPhone)
												.append(tdPayment)
												.append(tdStatus)
												.append(tdCreateTime)
												.append(tdOperation);
		$("#category_table tbody").append(tr);
	})
}

$(document).on('change','#orderStatus_select',function(){
	var orderStatus = parseInt($(this).val());
	if(orderStatus<0){
		getOrderList(1, 10, null, null);
	}else{
	getOrderList(1, 10, orderStatus, null);
	}
})

/**
 * 构建分页导航条
 * @param data
 */
function buildPageNav(data){
	if(data.hasPreviousPage){
		$("#btn_prePage").removeClass("layui-btn-disabled");
		$("#btn_prePage").click(function(){
			getOrderList(data.pageNum-1,10,status,null);
		})
	}else{
		$("#btn_prePage").addClass("layui-btn-disabled");
	}
	pages=data.pages;
	if(data.hasNextPage){
		$("#btn_nextPage").removeClass("layui-btn-disabled");
		$("#btn_nextPage").click(function(){
			getOrderList(data.pageNum+1,10,status,null);
		})
	}else{
		$("#btn_nextPage").addClass("layui-btn-disabled");
	}
	
	$("#navigation_nums").empty();
	var ulEle=$("<ul></ul>");
	$.each(data.navigatepageNums,function(index,item){
		var btnEle=$("<button></button>").addClass("layui-btn layui-btn-primary layui-btn-sm").append(item);
		if(data.pageNum == index +1){
			btnEle.addClass("layui-btn-disabled");
		}
		btnEle.click(function(){
			getOrderList(item,10,status,null);
		})
		var liEle=$("<li></li>").append(btnEle);
		ulEle.append(liEle);
	})
	$("#navigation_nums").append(ulEle);
	
	$("#pages").empty().append(data.pages);
	
}

/**
 * 点击了跳转页数
 */
$(document).on("click","#btn_skipPage",function(){
	var targetPage=parseInt($("#input_skipPage").val());
	if(!isEmpty(targetPage)&&targetPage <= pages){
		getOrderList(targetPage, 10, status,null)
	}
})


/**
 * 点击了搜索订单的按钮
 */
$(document).on('click','#btn_searchOrder',function(){
	searchOrder()
})

function searchOrder(){
	var orderNo = $('#orderNo').val();
	if(!isRightOrderNo(orderNo)){
		layer.msg('请输入正确格式的订单号');
		return;
	}
	getOrderList(1, 10, status,orderNo)
}

/**
 * 点击了发货
 */
$(document).on('click','.btnSendout',function(){
	var orderNo = $(this).attr('orderNo');
	if(isEmpty(orderNo)){
		layer.msg('获取订单号失败');
		return;
	}
	sendOut(orderNo);
})

function sendOut(orderNo){
	$.ajax({
		url:remotePath+"/manage/order/sendout",
		type:"POST",
		data:{"orderNo":orderNo},
		success:function(result){
			if(result.code == 100){
				layer.msg('发货成功')
				getOrderList(currentPage, 10, status, null)
			}else{
				layer.msg(result.msg)
			}
		},
		error:function(){
			layer.msg('网络连接失败')
		}
	})
}