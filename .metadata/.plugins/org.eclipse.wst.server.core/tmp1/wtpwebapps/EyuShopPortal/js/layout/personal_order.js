var currentOrderPageNum = 1,pages=0,orderStatus= -1;

$(function(){
	personal_orderCallback();
})

/**
 * 初始化函数
 */
function personal_orderCallback(){
	$("#personal_menu").children("li").removeClass("layui-this");
	$('#personal_order').addClass("layui-this");
	getOrderList(1,null,null);
}

/**
 * 点击了查看全部订单
 */
$("#order_all").on("click",function(){
	getOrderList(1,null,null);
	$(".order_nav_item").prop("style","font-size:14px;color:#c0c0c0");
	$(this).prop("style","font-size:16px;color:#fff");
})

/**
 * 点击了查看未付款订单
 */
$("#order_nopay").on("click",function(){
	orderStatus=10;
	getOrderList(1,orderStatus,null);
	$(".order_nav_item").prop("style","font-size:14px;color:#c0c0c0");
	$(this).prop("style","font-size:16px;color:#fff");
})

/**
 * 点击了查看等待收货订单
 */
$("#order_wait").on("click",function(){
	orderStatus=20;
	getOrderList(1,orderStatus,null);
	$(".order_nav_item").prop("style","font-size:14px;color:#c0c0c0");
	$(this).prop("style","font-size:16px;color:#fff");
})

/**
 * 点击了查看已完成订单
 */
$("#order_finish").on("click",function(){
	orderStatus=50;
	getOrderList(1,orderStatus,null);
	$(".order_nav_item").prop("style","font-size:14px;color:#c0c0c0");
	$(this).prop("style","font-size:16px;color:#fff");
})

/**
 * 获取订单列表
 */
function getOrderList(pageNum,orderStatus,orderNo){
	var data="pageNum="+pageNum+"&size=6";
	if(orderStatus != null ){
		data="pageNum="+pageNum+"&size=6&orderStatus="+orderStatus;
	}
	if(orderNo != null){
		data+="&orderNo="+orderNo;
	}
	console.log(data);
	$.ajax({
		url:remotePath+"/order/list",
		type:"GET",
		data:data,
		success:function(result){
			if(result.code == 100){
				buildOrderList(result.data);
				buildPageNav(result.data);
			}else{
				$("#content").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 构建订单列表
 * @param data
 */
function buildOrderList(data){
	$(".order-item").remove();
	
	$.each(data.list,function(index,item){
		var orderNoEle=$("<span></span>").append("订单号:").append(item.orderNo);
		var createTimeEle=$("<span></span>").prop({"style":"float:right;"}).append("创建时间:").append(item.createTime);
		var receiverNameEle=$("<span></span>").append("收件人:").append(item.shippingVo.receiverName);
		var receiverMobileEle=$("<span></span>").prop({"style":"float:right;"}).append("联系电话:").append(item.shippingVo.receiverMobile);
		var statusDescEle=$("<span></span>").append("订单状态:").append(item.statusDesc);
		if(item.status >= 20){
			statusDescEle.append("<br>").append("支付方式:").append(item.paymentTypeDesc);
		}
		var paymentEle=$("<span></span>").prop({"style":"float:right;"}).append("订单金额:").append(item.payment);
		var receiverAddressEle=$("<span></span>").append("收货地址:").append(item.shippingVo.receiverProvince)
				.append(item.shippingVo.receiverCity)
				.append(item.shippingVo.receiverDistrict)
				.append(item.shippingVo.receiverAddress);
		var receiverZipEle=$("<span></span>").append("邮编:").append(item.shippingVo.receiverZip);
		
		var orderItemHeaderEle=$("<div></div>").addClass("layui-row order-header")
				.append(orderNoEle)
				.append(createTimeEle)
				.append("<br>")
				.append(receiverNameEle)
				.append(receiverMobileEle)
				.append("<br>")
				.append(statusDescEle)
				.append(paymentEle)
				.append("<br>")
				.append(receiverAddressEle)
				.append("<br>")
				.append(receiverZipEle);
		
		var tbodyEle=$("<tbody></tbody>");
		$.each(item.orderItemVoList,function(i,product){
			var productImage=$("<img></img>").prop({"src":item.imageHost+product.productImage,"style":"display:inline;width:80px;height:80px;"})
			var productDiv=$("<div></div>").prop('style','float:left').append(productImage).append(product.productName);
			var productTd=$("<td></td>").append(productDiv);
			
			var quantityTd=$("<td></td>").append(product.quantity);
			var totalPriceTd=$("<td></td>").append(product.totalPrice);
			var statusTd=$("<td></td>").append(item.statusDesc);
			
			var btnEnsure=$("<li></li>").append($("<button></button>").addClass("layui-btn  layui-btn-xs btn_ensureOrder").append("确认收货"));
			var btnToPay=$("<li></li>").append($("<button></button>").addClass("layui-btn  layui-btn-xs btn_payOrder").append("点击付款"));
			var btnCancel=$("<li></li>").append($("<button></button>").addClass("layui-btn layui-btn-danger layui-btn-xs btn_cancelOrder").append("取消订单"));
			var ulEle=$("<ul></ul>");
			if(item.status == 10){
				ulEle.append(btnToPay).append(btnCancel);
			}else if(item.status >= 20){
				ulEle.append(btnEnsure);
			}
			var opTd=$("<td></td>").append(ulEle);
			
			var trEle=$("<tr></tr>")
					.append(productTd)
					.append(quantityTd)
					.append(totalPriceTd)
					.append(statusTd)
					.append(opTd);
			
			tbodyEle.append(trEle);
		})
		
		var theadEle=$("<thead></thead>").append("<tr ><th style='width:200px;'>商品</th><th >数量</th><th >金额</th><th >状态</th><th >操作</th></tr>");
		var tableEle=$("<table></table>").addClass('layui-table').attr({'lay-size':'sm'}).prop("style","width:100%;margin-top:0;").append(theadEle).append(tbodyEle);
		
		var orderItemDiv=$("<div></div>").addClass("layui-row order-item").attr("orderNo",item.orderNo).append(orderItemHeaderEle).append(tableEle).append("<hr>");
		
		$("#page_nav").before(orderItemDiv);
	})
}

/**
 * 点击了确认收货
 */
$(document).on("click",".btn_ensureOrder",function(){
	var orderNo=$(this).parents(".order-item").attr("orderNo");
	layer.confirm('确定无误了吗?', {
		icon : 3,
		title : '确认收货'
	}, function(index) {
		cancelOrder(orderNo);
		layer.close(index);
	});
})

/**
 * 点击了去付款
 */
$(document).on("click",".btn_payOrder",function(){
	var orderNo=$(this).parents(".order-item").attr("orderNo");
	$("#content").load(path+"/jsp/modules/module_alipay.jsp",{},function(){
		module_alipayCallback(orderNo);
	});
})


/**
 * 取消订单
 * @param orderNo
 */
function cancelOrder(orderNo){
	$.ajax({
		url:remotePath+"/order/cancel",
		type:"POST",
		data:{"orderNo":orderNo},
		success:function(result){
			getOrderList(currentOrderPageNum,orderStatus,null);
		}
	})
}

/**
 * 点击了跳转页数
 */
$(document).on("click","#btn_skipPage",function(){
	console.log("btn_skipPage")
	var targetPage=parseInt($("#input_skipPage").val());
	if(!isEmpty(targetPage)&&targetPage <= pages){
		getOrderList(targetPage,orderStatus,null);
	}
})


/**
 * 点击了取消订单
 */
$(document).on("click",".btn_cancelOrder",function(){
	var orderNo=$(this).parents(".order-item").attr("orderNo");
	layer.confirm('该订单取消后，享受的优惠也一并取消,确认取消吗?', {
		icon : 3,
		title : '取消订单'
	}, function(index) {
		cancelOrder(orderNo);
		layer.close(index);
	});
})

/**
 * 点击了搜索订单
 */
$(document).on("click","#btn_searchOrder",function(){
	var orderNo=$("#orderNo").val();
	if(!isEmpty(orderNo)){
		 var reg=/^[0-9]*$/;
		 if(!reg.test(orderNo)){
			 layer.msg("订单号格式不正确");
		 }else{
			 getOrderList(1,null,orderNo);
		 }
	}else{
		layer.msg("请输入要搜索的订单号");
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
			getOrderList(data.pageNum-1,orderStatus,null);
		})
	}else{
		$("#btn_prePage").addClass("layui-btn-disabled");
	}
	pages=data.pages;
	if(data.hasNextPage){
		$("#btn_nextPage").removeClass("layui-btn-disabled");
		$("#btn_nextPage").click(function(){
			getOrderList(data.pageNum+1,orderStatus,null);
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
			getOrderList(item,orderStatus,null);
		})
		var liEle=$("<li></li>").append(btnEle);
		ulEle.append(liEle);
	})
	$("#navigation_nums").append(ulEle);
	
	$("#pages").empty().append(data.pages);
	
}