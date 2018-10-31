$(function(){
	personal_cartCallback()
})
/**
 * 初始化函数
 */
function personal_cartCallback(){
	$("#personal_menu").children("li").removeClass("layui-this");
	$('#personal_cart').addClass("layui-this");
	getCartList();
}

/**
 * 点击了返回购物车
 */
$(document).on("click","#btn_returnToCart",function(){
	window.location.reload();
})

/**
 * 获取购物车列表
 */
function getCartList(){
	$.ajax({
		url:remotePath+"/cart/list",
		type:"GET",
		success:function(result){
			console.log(result);
			if(result.code == 100){
				calcSummary(result.data);
				buildCartProductList(result.data);
			}else{
				$("#content").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 计算总汇
 */
function calcSummary(data){
	if(data.allChecked){
		$("#btn_selectAllCart").prop("checked",true);
	}else{
		$("#btn_selectAllCart").prop("checked",false);
	}
	
	$("#cart_quantity").empty().append(data.totalQuantity==null?'0':data.totalQuantity);
	$("#cart_totalPrice").empty().append(data.cartTotalPrice);
}

/**
 * 点击了去结算
 */
$(document).on("click","#btn_calcCart",function(){
	console.log("click the btn_calcCart");
	$("#content").empty();
	$("#content").load(path + "/jsp/layout/personal_choose_shipping.jsp", {
		"type" : 1
	}, function() {
		cart_getShippingList();
	});
})

/**
 * 获取用户保存的地址列表
 */
function cart_getShippingList(){
	$.ajax({
		url : remotePath + "/shipping/list",
		type : "GET",
		success : function(result) {
			if (result.code == 100) {
				cart_buildShippingList(result.data);
			} else {
				alert("获取不到数据呐");
			}
		}
	})
}

/**
 * 构建收货地址列表
 * @param data
 */
function cart_buildShippingList(data){
	$(".cart-shippingItem").remove();
	$.each(data,function(index, item) {
		
		var radio=$("<input></input>").prop({"type":"radio","name":"shippingId","value":item.shippingId});
		if(index == 0){
			radio.prop("checked",true);
		}
		// 收货人姓名
		var username = $("<span></span>").addClass("cart-shippingName").append(
				item.receiverName);


		// 收货人手机号码
		var mobile = $("<span></span>").addClass("cart-shippingMobile").append(
				item.receiverMobile);

		// 收货人地址
		var address = $("<span></span>").addClass("cart-shippingAddress").append(
				item.receiverProvince + item.receiverCity
						+ item.receiverDistrict
						+ item.receiverAddress);



		var shippingItem = $("<div></div>").addClass("row cart-shippingItem")
						.append(radio).append(username).append(mobile).append(address);

		$("#shipping_choose_list").append(shippingItem);
	})
}

/**
 * 点击了删除
 */
$(document).on("click",".btn_deleteCart",function(){
	console.log("click the btn_deleteCart");
	var productId=$(this).parents(".cart_productItem").attr("productId");
	layer.confirm('确认删除吗?', {
		icon : 3,
		title : '删除商品'
	}, function(index) {
		deleteCart(productId);
		layer.close(index);
	});
})

function deleteCart(productId){
	$.ajax({
		url:remotePath+"/cart/delete",
		type:"POST",
		data:{"productId":productId},
		success:function(result){
			if(result.code == 100){
				calcSummary(result.data);
				buildCartProductList(result.data);
			}else{
				alert("删除失败");
			}
		}
	})
}


/**
 * 填充购物车数据表格
 * @param data
 */
function buildCartProductList(data){
	var productList=data.cartProductList;
	$(".cart_productItem").remove();
	$.each(productList,function(index,item){
		//复选框
		var checkedInput=$("<input></input>").addClass("cart_checkbox").prop({"type":"checkbox","checked":item.productChecked}).attr({"lay-skin":"primary"});
		var checkedEle=$("<td></td>").append(checkedInput);
		
		//商品图片和名字
		var productImage=$("<img></img>").prop({"src":data.imageHost+item.productForeground,"style":"width:80px;height:80px;background-color:gray;"});
		var productName=$("<span></span>").append(item.productName);
		var productDiv=$("<div></div>").addClass("layui-col-sm-4").append(productImage).append(productName);
		var productEle=$("<td></td>").prop("style","text-align:left;").append(productDiv);
		
		//价格
		var productUnitPrice= $("<span></span>").append(item.productUnitPrice);
		var priceEle=$("<td></td>").append(productUnitPrice);
		
		//数量
		var btnMinus=$("<button></button>").prop("style","display:none;border:none;background-color:#fff;font-size:25px;color:#CD0000").addClass("btn_minusCart").append("-");
		var btnPlus=$("<button></button>").prop("style","display:none;border:none;background-color:#fff;font-size:25px;color:#CD0000").addClass("btn_plusCart").append("+");
		var quantityInput=$("<input></input>").addClass("productQuantity").prop({"style":"width:28px;height:20px;","type":"text","value":item.quantity})
		var quantityEle=$("<td></td>").append(btnMinus).append(quantityInput).append(btnPlus);
		
		//小计
		var totalPrice=$("<span></span>").append(item.productTotalPrice);
		var totalPriceEle=$("<td></td>").append(totalPrice);
		
		var deleteBtn=$("<button></button>").addClass("layui-btn layui-btn-danger layui-btn-xs btn_deleteCart").append("删除");
		var opEle=$("<td></td>").append(deleteBtn);
		
		var trEle=$("<tr></tr>").addClass("cart_productItem").attr("productId",item.productId)
							.attr({"productId":item.productId})
							.append(checkedEle)
							.append(productEle)
							.append(priceEle)
							.append(quantityEle)
							.append(totalPriceEle)
							.append(opEle);
		
		$("#calcSummary").before(trEle);
	})
	if(productList.length==0){
		var emptyEle=$("<tr></tr>").prop("style","text-align:center;color:#ccc;padding:5px;").append("您的购物车空空如也");
		$("#calcSummary").before(emptyEle);
	}
}

$(document).on("click",".cart_checkbox",function(){
	var productId=$(this).parent().attr("productId");
	var checked=$(this).prop("checked");
	if(checked){
		checkedCartByProductId(productId);
	}else{
		uncheckedCartByProductId(productId);
	}
})

/**
 * 勾选了某个商品
 * @param productId
 */
function checkedCartByProductId(productId){
	$.ajax({
		url:remotePath+"/cart/checked",
		type:"PUT",
		data:{"productId":productId},
		success:function(result){
			if(result.code == 100){
				calcSummary(result.data);
				buildCartProductList(result.data);
			}else{
				alert("操作失败");
			}
		}
	})
}

/**
 * 取消勾选某个商品
 * @param productId
 */
function uncheckedCartByProductId(productId){
	$.ajax({
		url:remotePath+"/cart/unchecked",
		type:"PUT",
		data:{"productId":productId},
		success:function(result){
			if(result.code == 100){
				calcSummary(result.data);
				buildCartProductList(result.data);
			}else{
				alert("操作失败");
			}
		}
	})
}

/**
 * 点击了减少数量
 */
$(document).on("click",".btn_minusCart",function(){
	var quantity=parseInt($(this).parent().children("input").val());
	var productId = $(this).parents(".cart_productItem").attr("productId");
	console.log(quantity);
	quantity=quantity-1;
	$(this).parents(".cart_productItem").val(quantity+"");
	updateProductQuantity(productId,quantity);
})

/**
 * 点击了增加数量
 */
$(document).on("click",".btn_plusCart",function(){
	var quantity=parseInt($(this).parent().children("input").val());
	var productId = $(this).parents(".cart_productItem").attr("productId");
	console.log(quantity);
	quantity=quantity+1;
	$(this).parents(".cart_productItem").val(quantity);
	updateProductQuantity(productId,quantity);
})

/**
 * 更新购物车的商品数量
 * @param productId
 * @param count
 */
function updateProductQuantity(productId,count){
	$.ajax({
		url:remotePath+"/cart/update",
		type:"PUT",
		data:{"productId":productId,"count":count},
		success:function(result){
			if(result.code != 100){
				alert("操作失败");
			}
		}
	})
}

/**
 * 点击了确认选择地址
 */
$(document).on("click","#btn_ensureCreateOrder",function(){
	console.log("btn_ensureCreateOrder");
	var shippingId=$("input[name='shippingId']:checked").val();
	$.ajax({
		url:remotePath+"/order/create",
		type:"POST",
		data:{"shippingId":shippingId},
		success:function(result){
			if(result.code == 100){
				var orderNo=result.data.orderNo;
				$("#content").load(path+"/jsp/modules/module_alipay.jsp",{},function(){
					console.log("btn_ensureCreateOrder---"+orderNo);
					module_alipayCallback(orderNo);
				});
			}else{
				alert("操作失败");
			}
		}
			
	})
})

