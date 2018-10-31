layui.use('element', function() {
	var element = layui.element;

});

/**
 * 初始化函数
 */
$(function(){
	initNavBar();
})

function initNavBar(){
	var currentUser;
	$.ajax({
		url:path+"/get_attribute",
		type:"GET",
		success:function(result){
			currentUser=result;
			if(isEmpty(currentUser)){
				showLoginAndRegisterPanel();
			}else{
				showUserPanel();
				header_getNotifyCount();
				header_getCartCount();
			}
		}
	})
	
}

function showUserPanel(){
	$("#loginAndRegisterPanel").remove();
	$("#userInfoPanel").show();
}

function showLoginAndRegisterPanel(){
	$("#userInfoPanel").remove();
	$("#loginAndRegisterPanel").show();
}

/**
获取通知消息
*/
function header_getNotifyCount(){
	console.log("header_getNotifyCount")
	$.ajax({
		url:remotePath+"/notify/count",
		type:"GET",
		success:function(result){
			if(result.code == 100){
				if(result.data>0){
					$("#header_message_count").empty().append(result.data);
				}
			}
		}
	})
}

/**
获取购物车的数量
*/
function header_getCartCount(){
	$.ajax({
		url:remotePath+"/cart/get_count_in_cart",
		type:"GET",
		success:function(result){
			if(result.code == 100){
				$("#header_cart_count").empty().append(result.data);
			}
		}
	})
}

/**
 * 点击了去登录
 */
$("#btn_toLogin").on("click", function() {
	window.location.replace(path+"/login");
})
/**
 * 点击了去注册
 */
$("#btn_toRegister").on("click", function() {
	window.location.replace(path+"/register");
})

/**
 * 点击了注销登录
 */
$(document).on("click","#btn_logout",function(){
	$.ajax({
		url:remotePath+"/user/logout",
		type:"GET",
		success:function(result){
			if(result.code == 100){
				window.location.href="/EyuShopPortal/index";
			}
		}
	})
	$.ajax({
		url:path+"/logout",
		type:"GET",
		success:function(result){
			
		}
	})
})