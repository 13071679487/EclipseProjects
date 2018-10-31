var element;
layui.use('element', function(){
	element = layui.element;
  
});
var form;
layui.use('form', function(){
	  form = layui.form;
	  
	  form.on('submit(btn_submitShipping)', function(data) {
		  saveOrUpdateShipping(data.field);
			return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
	  });
});
var table;
layui.use('table', function(){
	  table = layui.table;
	  
});
var layer;
layui.use('layer', function(){
	  layer = layui.layer;
	  
}); 

$(function(){
//	var currentUrl=window.location.href;
//	var anchor=getAnchorFromUrl(currentUrl);
//	if(!isEmpty(anchor)){
//		anchor="#"+anchor;
//		$(anchor).click();
//		$("#personal_menu").children("li").removeClass("layui-this");
//		$(anchor).addClass("layui-this");
//	}else{
//		personal_infoCallback();
//	}
})


///**
// * 点击了查看用户资料
// */
//$(document).on("click","#personal_info",function(){
//	$("#content").empty();
//	var url=$(this).attr("url");
//	if(url==''||url==null){
//		return;
//	}
//	
//	$("#content").load(url,{},function(){
//		personal_infoCallback();
//	});
//})
//
///**
// * 点击了查看消息
// */
//$(document).on("click","#personal_message",function(){
//	$("#content").empty();
//	var url=$(this).attr("url");
//	if(url==''||url==null){
//		return;
//	}
//	
//	$("#content").load(url,{},function(){
//		personal_messageCallback();
//	});
//})
//
///**
// * 点击了查看购物车
// */
//$(document).on("click","#personal_cart",function(){
//	$("#content").empty();
//	var url=$(this).attr("url");
//	if(url==''||url==null){
//		return;
//	}
//	
//	$("#content").load(url,{},function(){
//		personal_cartCallback();
//	});
//})
//
///**
// * 点击了查看订单列表
// */
//$(document).on("click","#personal_order",function(){
//	$("#content").empty();
//	var url=$(this).attr("url");
//	if(url==''||url==null){
//		return;
//	}
//	
//	$("#content").load(url,{},function(){
//		personal_orderCallback();
//	});
//})
//
///**
// * 点击了查看我的收藏
// */
//$(document).on("click","#personal_collection",function(){
//	$("#content").empty();
//	var url=$(this).attr("url");
//	if(url==''||url==null){
//		return;
//	}
//	
//	$("#content").load(url,{},function(){
//		personal_collectionCallback();
//	});
//})
//
///**
// * 点击了查看收货地址列表
// */
//$(document).on("click","#personal_shipping",function(){
//	$("#content").empty();
//	var url=$(this).attr("url");
//	if(url==''||url==null){
//		return;
//	}
//	
//	$("#content").load(url,{},function(){
//		personal_shippingCallback();
//	});
//})
//
///**
// * 点击了查看浏览记录
// */
//$(document).on("click","#personal_record",function(){
//	$("#content").empty();
//	var url=$(this).attr("url");
//	if(url==''||url==null){
//		return;
//	}
//	
//	$("#content").load(url,{},function(){
//		personal_recordCallback();
//	});
//})



