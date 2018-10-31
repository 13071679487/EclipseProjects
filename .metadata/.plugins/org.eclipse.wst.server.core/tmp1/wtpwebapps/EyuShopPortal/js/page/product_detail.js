var element;
layui.use('element', function() {
	element = layui.element;

});
var layer;
layui.use('layer', function(){
  layer = layui.layer;
  
});

$(function(){
	init();
})

/**
 * 初始化函数
 */
function init(){
	var pid=getUrlParam("pid");
	getProductInfo(pid);
}

/**
 * 获取该商品信息
 */
function getProductInfo(pid){
	$.ajax({
		url:remotePath+"/product/info",
		type:'GET',
		data:{"pid":pid},
		success:function(result){
			if(result.code == 100){
				buildProductInfo(result.data);
			}else{
				$("#product-item").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 构建商品信息
 */
function buildProductInfo(data){
	$("#foreground").prop("src",data.imageHost+data.foreground);
	$("#productName").empty().append(data.productName);
	$("#subtitle").empty().append(data.subtitle);
	$("#price").empty().append(data.price);
	$("#stock").empty().append(data.stock);
	$("#product_detail").empty().append(data.detail);
	var subimages=data.subimages.split(",");
	$("#subimages").empty();
	$.each(subimages,function(index,imageName){
		var imgEle=$("<img></img>").prop({"style":"height:48px;width:48px;","src":data.imageHost+imageName});
		var liEle=$("<li></li>").append(imgEle);
		$("#subimages").append(liEle);
	})
}

/**
 * 点击了数量减
 */
$("#btn_minus").on("click",function(){
	var quantity=$("#quantity").val();
	var result=parseInt(quantity)-1;
	if(quantity>1){
		$("#quantity").val(result);
	}
})

/**
 * 点击了数量加
 */
$("#btn_plus").on("click",function(){
	var quantity=$("#quantity").val();
	var result=parseInt(quantity)+1;
	$("#quantity").val(result);
})

/**
 * 点击了加入购物车
 */
$("#btn_addToCart").on("click",function(){
	var productId=getUrlParam("pid");
	var quantity=$("#quantity").val();
	if(quantity>0){
		addToCart(productId,quantity);
	}else{
		layer.msg('请选择正确的数量');
	}
})

/**
 * 加入到购物车
 * @param productId
 * @param quantity
 */
function addToCart(productId,quantity){
	$.ajax({
		url:remotePath+"/cart/add",
		type:"POST",
		data:{"productId": productId,"count":quantity},
		success:function(result){
			if(result.code ==100){
				layer.msg('加入购物车成功');
			}else{
				  layer.msg(result.msg);
			}
		}
	})
}
