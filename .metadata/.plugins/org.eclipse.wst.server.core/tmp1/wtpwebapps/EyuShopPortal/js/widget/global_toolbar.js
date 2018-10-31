var currentUser;
var layer;
layui.use('layer', function(){
  layer = layui.layer;
  
});

$(function(){
	initGlobalToolbar();
})
/**
初始化全局toolbar的信息
*/
function initGlobalToolbar(){
	$.ajax({
		url:path+"/get_attribute",
		type:"GET",
		success:function(result){
			currentUser=result;
			if(!isEmpty(currentUser)){
				getNotifyCount();
				getCartProductCount();	
			}
		}
	})
}
	/**
获取通知消息
*/
function getNotifyCount(){
	$.ajax({
		url:remotePath+"/notify/count",
		type:"GET",
		success:function(result){
			if(result.code == 100){
				if(result.data>0){
					$("#globalbar_message").after("<span class='layui-badge' style='display:inline;'>"+result.data+"</span>");
				}
			}
		}
	})
}

/**
获取购物车的数量
*/
function getCartProductCount(){
	$.ajax({
		url:remotePath+"/cart/get_count_in_cart",
		type:"GET",
		success:function(result){
			if(result.code == 100){
				$("#globalbar_cart").after("<span class='layui-badge' style='display:inline;'>"+result.data+"</span>");
			}
		}
	})
}

/**
 * 点击了消息
 */
$("#globalbar_message").on("click",function(){
	if(!isEmpty(currentUser)){
		window.location.href=path+"/"+currentUser.account+"/msg";
	}else{
		layer.msg("请先登录");
	}
})

/**
 * 点击了购物车
 */
$("#globalbar_cart").on("click",function(){
	if(!isEmpty(currentUser)){
		window.location.href=path+"/"+currentUser.account+"/cart";
	}else{
		layer.msg("请先登录");
	}
})

/**
 * 点击了个人中心
 */
$("#globalbar_personal").on("click",function(){
	console.log("click the globalbar_personal")
	if(!isEmpty(currentUser)){
		window.location.href=path+"/"+currentUser.account;
	}else{
		layer.msg("请先登录");
	}
})