$(function(){
	getRepertoryRecordList(1)
})

/**
 * 获取记录列表
 * @param pn
 * @param size
 */
function getRepertoryRecordList(pn){
	$.ajax({
		url:remotePath+'/manage/repertory/list',
		type:'GET',
		data:{'pn':pn,'size':20},
		success:function(result){
			if(result.code ==100){
				//TODO
				buildRepertoryRecordList(result.data);
				buildPageNav(result.data);
			}else{
				layer.msg(result.msg)
			}
		},
		error:function(){
			layer.msg('连接网络错误')
		}
	})
}

function buildRepertoryRecordList(data){
		$("#repertory_table tbody").empty();
		$.each(data.list,function(index,item){
			var idTd=$("<td></td>").addClass("layui-table-cell").append(item.id);
			var productIdTd=$("<td></td>").addClass("layui-table-cell").append(item.productId);
			var productNameTd=$("<td></td>").addClass("layui-table-cell").append(item.productName);
			var recordTypeTd=$("<td></td>").addClass("layui-table-cell").append(item.recordType);
			var unitTd=$("<td></td>").addClass("layui-table-cell").append(item.unit);
			var unitPriceTd=$("<td></td>").addClass("layui-table-cell").append(item.unitPrice);
			var amountTd=$("<td></td>").addClass("layui-table-cell").append(item.amount);
			var providerTd=$("<td></td>").addClass("layui-table-cell").append(item.provider);
			var createTimeTd=$("<td></td>").addClass("layui-table-cell").append(item.createTime);
			var updateTimeTd=$("<td></td>").addClass("layui-table-cell").append(item.updateTime);
			
			var trEle=$("<tr></tr>").attr("index",index)
					.append(idTd)
					.append(productIdTd)
					.append(productNameTd)
					.append(amountTd)
					.append(unitTd)
					.append(unitPriceTd)
					.append(recordTypeTd)
					.append(providerTd)
					.append(createTimeTd)
					.append(updateTimeTd);
			$("#repertory_table tbody").append(trEle);
		})
}

/**
 * 构建分页导航条
 * @param data
 */
function buildPageNav(data){
	if(data.hasPreviousPage){
		$("#btn_prePage").removeClass("layui-btn-disabled");
		$("#btn_prePage").click(function(){
			buildRepertoryRecordList(data.pageNum-1);
		})
	}else{
		$("#btn_prePage").addClass("layui-btn-disabled");
	}
	pages=data.pages;
	if(data.hasNextPage){
		$("#btn_nextPage").removeClass("layui-btn-disabled");
		$("#btn_nextPage").click(function(){
			buildRepertoryRecordList(data.pageNum+1);
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
			buildRepertoryRecordList(item);
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
		buildRepertoryRecordList(targetPage);
	}
})

$(document).on('click','#btn_createRepertoryRecord',function(){
	$(".layui-body").empty();
	$(".layui-body").load(path+"/jsp/manage/repertory/repertory_record_save.jsp")
})

$(document).on('click','#btn_returnToRepertory',function(){
	window.location.href=path+'/admin/reper'
})