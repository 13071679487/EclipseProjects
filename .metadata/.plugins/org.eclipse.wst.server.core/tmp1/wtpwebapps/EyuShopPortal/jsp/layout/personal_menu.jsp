<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
		#personal_menu{
		width: auto;
		}
	
		#personal_menu li i{
			font-size:16px;
		}
		#personal_menu li{
			cursor:pointer;
		}
	</style>
</head>
<ul id="personal_menu" class="layui-nav layui-nav-tree" lay-filter="personal_menu">
	<li id="personal_info" class="layui-nav-item" url="jsp/layout/personal_info.jsp"><a href='/EyuShopPortal/${currentUser.account}'><i class="layui-icon layui-icon-username"></i>&nbsp;个人资料</a></li>
	<li id="personal_message" class="layui-nav-item" url="jsp/layout/personal_message.jsp"><a href='/EyuShopPortal/${currentUser.account}/msg'><i class="layui-icon layui-icon-notice"></i>&nbsp;消息</a></li>
	<li id="personal_cart" class="layui-nav-item" url="jsp/layout/personal_cart.jsp"><a href='/EyuShopPortal/${currentUser.account}/cart'><i class="layui-icon layui-icon-cart-simple"></i>&nbsp;我的购物车</a></li>
	<li id="personal_order" class="layui-nav-item" url="jsp/layout/personal_order.jsp"><a href='/EyuShopPortal/${currentUser.account}/order'><i class="layui-icon layui-icon-form"></i>&nbsp;我的订单</a></li>
	<li id="personal_collection" class="layui-nav-item" url="jsp/layout/personal_collection.jsp"><a href='/EyuShopPortal/${currentUser.account}/col'><i class="layui-icon layui-icon-rate"></i>&nbsp;我的收藏</a></li>
	<li id="personal_shipping" class="layui-nav-item" url="jsp/layout/personal_shipping.jsp"><a href='/EyuShopPortal/${currentUser.account}/shipping'><i class="layui-icon layui-icon-location"></i>&nbsp;收货地址管理</a></li>
	<li id="personal_record" class="layui-nav-item" url="jsp/layout/personal_record.jsp"><a href='/EyuShopPortal/${currentUser.account}/rec'><i class="layui-icon layui-icon-chart"></i>&nbsp;浏览记录</a></li>
</ul>
</html>