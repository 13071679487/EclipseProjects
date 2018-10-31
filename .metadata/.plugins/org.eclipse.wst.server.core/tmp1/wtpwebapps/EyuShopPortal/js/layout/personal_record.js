var recordCurrentPage = 1;
$(function(){
	personal_recordCallback()
})

/**
 * 初始化函数
 */
function personal_recordCallback(){
	$("#personal_menu").children("li").removeClass("layui-this");
	$('#personal_record').addClass("layui-this");
	getRecordList(1);
}

/**
 * 获取记录列表
 */
function getRecordList(pageNum){
	recordCurrentPage=pageNum;
	$.ajax({
		url:remotePath+"/record/list",
		type:"GET",
		data:{"pn":pageNum},
		success:function(result){
			if(result.code == 100){
				buildRecordList(result.data);
				buildPageNav(result.data);
			}else{
				$("#record_content").empty().load(path+"/jsp/widget/error404.jsp");
			}
			
		}
	})
}

/**
 * 构建记录列表
 * @param data
 */
function buildRecordList(data){
	$("#record_table").empty();
	$.each(data.list,function(index,item){
//		var recordImg=$("<img></img>").prop("src",item.imageHost+item.productForeground);
//		var hrefEle=$("<a></a>").prop("href",path+"/product?pid="+item.productId)
//							.append(recordImg)
//							.append("<span class='record-item-title'>"+item.productName+"</span>")
//							.append("<span class='record-item-price'><i class='layui-icon layui-icon-rmb'></i>"+item.productPrice+"</span>");
		
		var productImage=$("<img></img>").prop({"src":item.imageHost+item.productForeground,"style":"display:inline;width:72px;height:72px;"})
		var productDiv=$("<div></div>").prop('style','float:left;').append(productImage).append(item.productName);
		var hrefEle=$("<a></a>").prop("href",path+"/product?pid="+item.productId).append(productDiv)
		var productTd=$("<td></td>").prop('style','padding:3px;').append(hrefEle);
		
		var priceTd=$("<td></td>").append("<span class='record-item-price'><i class='layui-icon layui-icon-rmb'></i>"+item.productPrice+"</span>");
		
		var deleteTd=$('<td></td>').append("<button class='layui-btn layui-btn-danger layui-btn-xs btn_deleteRecord'>删除</button>");
		
		var recordItemTr=$("<tr></tr>").addClass("layui-row record-item").attr("recordId",item.recordId)
								.append(productTd)
								.append(priceTd)
								.append(deleteTd);
								
								
		
		$("#record_table").append(recordItemTr);
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
			getRecordList(data.pageNum-1);
		})
	}else{
		$("#btn_prePage").addClass("layui-btn-disabled");
	}
	pages=data.pages;
	if(data.hasNextPage){
		$("#btn_nextPage").removeClass("layui-btn-disabled");
		$("#btn_nextPage").click(function(){
			getRecordList(data.pageNum+1);
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
			getRecordList(item);
		})
		var liEle=$("<li></li>").append(btnEle);
		ulEle.append(liEle);
	})
	$("#navigation_nums").append(ulEle);
	
	$("#pages").empty().append(data.pages);
	
}

/**
 * 点击了删除该条记录
 */
$(document).on("click",".btn_deleteRecord",function(){
	var recordId=$(this).parents(".record-item").attr("recordId");
	if(!isEmpty(recordId)){
		deleteRecord(recordId);
	}
})

/**
 * 删除一条记录的逻辑
 * @param recordId
 */
function deleteRecord(recordId){
	$.ajax({
		url:remotePath+"/record/delete",
		type:"POST",
		data:{"rid":recordId},
		success:function(result){
			if(result.code == 100){
				getRecordList(recordCurrentPage);
			}else{
				layer.msg("删除失败");
			}
		}
	})
}

/**
 * 点击了清空所有记录
 */
$(document).on("click","#btn_deleteAllRecord",function(){
	console.log("click the btn_deleteAllRecord");
	$.ajax({
		url:remotePath+"/record/delete_all",
		type:"POST",
		success:function(result){
			if(result.code == 100){
				getRecordList(1);
			}else{
				layer.msg("删除失败");
			}
		}
	})
})

