<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path=request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<html>
<head>
	<style type="text/css">
	#global_toolbar ul li {
		margin-top:5px;	
	}
	#global_toolbar ul li i{
		font-size:28px;
		color:#009688;
	}
	#global_toolbar ul li i{
		font-size:28px;
		color:#009688;
	}
	#global_toolbar ul li{
		position:relative;
		cursor:pointer;
	}
	#global_toolbar ul li .layui-badge{
		position:absolute;
		top:0;
		right:0;
	}
	</style>
</head>

	<div id="global_toolbar" style="background-color:rgb(240,240,240);position:fixed;right:3%;width:56px;bottom:50px;border:2px solid rgba(200,200,200,.8);border-radius:3px;text-align: center;">
		<ul>
			<li>
				<a title="联系客服">
					<i id="globalbar_reply" class="layui-icon layui-icon-dialogue"></i>
				</a>
			</li>
		
			<li>
				<a title="消息通知">
					<i id="globalbar_message" class="layui-icon layui-icon-notice"></i>
				</a>
			</li>
			
			<li>
				<a title="我的购物车">
					<i id="globalbar_cart" class="layui-icon layui-icon-cart-simple"></i>
				</a>
			</li>
			
			<li>
				<a title="个人中心">
					<i id="globalbar_personal" class="layui-icon layui-icon-username"></i>
				</a>
			</li>
		</ul>
	</div>
	
	<script type="text/javascript" src="${path }/js/widget/global_toolbar.js"></script>
</html>