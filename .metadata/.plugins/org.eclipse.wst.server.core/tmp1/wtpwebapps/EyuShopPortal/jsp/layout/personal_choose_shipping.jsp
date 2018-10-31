<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.cart-shippingItem{
		margin-top:15px;
		margin-left:30px;
		padding:5px;
		color:#444;
		border-bottom:1px solid #ccc;
	}
	.cart-shippingName{
		font-size:18px;
		margin-left:15px;
	}
	.cart-shippingMobile{
		font-size:16px;
		margin-left:30px;
	}
	.cart-shippingAddress{
		font-size:16px;
		margin-left:30px;
	}
</style>
</head>
				<div class="layui-row">
					<button id="btn_returnToCart" class="layui-btn layui-btn-sm" style="width:35px;height:35px;border-radius:50%;">
						<i class="layui-icon layui-icon-return" style=""></i>
					</button>
					<span style="font-size:15px;color:#444;">返回购物车</span>
				</div>
				
				<div class="row" id="shipping_choose_list">
					
					
				</div>
				
				<div class="layui-row" style="margin-top:36px;">
					<button id="btn_ensureCreateOrder" class="layui-btn layui-btn-sm" style="float:right;font-size:14px;height:38px;width:108px;background-color:#CD0000;">
						确定
					</button>
				</div>
</html>