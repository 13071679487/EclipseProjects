var messageCurrentPage = 1;

$(function(){
	personal_messageCallback()
})

/**
 * 初始化函数
 */
function personal_messageCallback(){
	$("#personal_menu").children("li").removeClass("layui-this");
	$('#personal_message').addClass("layui-this");
	getMessageList(1);
}

/**
 * 获取消息列表
 * @param pageNum
 */
function getMessageList(pageNum){
	messageCurrentPage=pageNum;
	$.ajax({
		url:remotePath+"/notify/list",
		type:"GET",
		data:{"pn":pageNum},
		success:function(result){
			if(result.code ==100){
				buildMessageList(result.data);
				buildPageNav(result.data);
			}else{
				$("#message_content").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 构建消息列表
 */
function buildMessageList(data){
	$("#message_content").empty();
	$.each(data.list,function(index,item){
		var cardHeaderDiv=$("<div></div>").addClass("layui-card-header")
								.append("<h4 style='display:inline;''>"+item.notifyTitle+"</h4>")
								.append("<i class='message-close layui-icon layui-icon-close layui-layout-right' style='font-size:18px;color:#fff;margin-right:10px;'></i>");
		var cardBodyDiv=$("<div></div>").addClass("layui-card-body")
											.append(item.notifyMsg);
		if(!isEmpty(item.notifyHref)){
			cardBodyDiv.append("<a href='"+item.notifyHref+"'>查看详情</a>");
		}
		
		var cardDiv=$("<div></div>").addClass("layui-card").prop("style","border-radius:20px;").append(cardHeaderDiv).append(cardBodyDiv);
		var messageItemDiv=$("<div></div>").attr({"messageId":item.notifyId,"index":index}).addClass("layui-row message-item").append(cardDiv); 
		
		$("#message_content").append(messageItemDiv);
	})
}

/**
 * 点击了删除该条消息
 */
$(document).on("click",".message-close",function(event){
	var notifyId=$(this).parents(".message-item").attr("messageId");
	var index=$(this).parents(".message-item").attr("index");
	deleteNotify(notifyId,index);
	event.stopPropagation();
})

function deleteNotify(notifyId,index){
	$.ajax({
		url:remotePath+"/notify/delete",
		type:"POST",
		data:{"nid":notifyId},
		success:function(result){
			if(result.code == 100){
				$(".message-item:eq("+index+")").fadeOut('slow');
			}else{
				layer.msg("删除失败");
			}
		}
	})
}

$(document).on("click","#btn_deleteAllNotify",function(){
	$.ajax({
		url:remotePath+"/notify/delete_all",
		type:"POST",
		success:function(result){
			if(result.code ==100 ){
				getMessageList(1);
			}else{
				layer.msg("删除失败");
			}
		}
	})
})

/**
 * 构建分页导航条
 * @param data
 */
function buildPageNav(data){
	if(data.hasPreviousPage){
		$("#btn_prePage").removeClass("layui-btn-disabled");
		$("#btn_prePage").click(function(){
			getMessageList(data.pageNum-1);
		})
	}else{
		$("#btn_prePage").addClass("layui-btn-disabled");
	}
	pages=data.pages;
	if(data.hasNextPage){
		$("#btn_nextPage").removeClass("layui-btn-disabled");
		$("#btn_nextPage").click(function(){
			getMessageList(data.pageNum+1);
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
			getMessageList(item);
		})
		var liEle=$("<li></li>").append(btnEle);
		ulEle.append(liEle);
	})
	$("#navigation_nums").append(ulEle);
	
	$("#pages").empty().append(data.pages);
	
}