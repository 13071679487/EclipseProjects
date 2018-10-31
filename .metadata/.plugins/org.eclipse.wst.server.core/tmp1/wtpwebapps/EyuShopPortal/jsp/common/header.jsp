<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="layui-header layui-bg-green">
	<ul class="layui-nav  layui-bg-green" lay-filter="">
	  <li class="layui-nav-item">
		  <a href="${path }/index">
			  <!-- <img src="http://t.cn/RCzsdCq" class="layui-nav-img"> -->
			  <span class="logo">五邑商城</span>
		  </a>
	  </li>
	  </ul>
	  
	  <ul id="loginAndRegisterPanel" class="layui-nav layui-layout-right layui-bg-green" style="margin-right:30px;margin-top:15px;display:none;">
	  <li  class="layui-nav-item" >
	  	<button id="btn_toLogin" style="width:64px;" class="layui-btn layui-btn-radius layui-btn-normal layui-btn-sm">登录</button>
	  </li>
	  <li  class="layui-nav-item" >
	  	<button id="btn_toRegister" style="width:64px;margin-left:10px;" class="layui-btn layui-btn-radius layui-btn-danger layui-btn-sm">注册</button>
	  </li>
	  </ul>
	  
	  <ul id="userInfoPanel" class="layui-nav layui-layout-right layui-bg-green" style="display:none;">
	   <%-- <li id="messagePanel"  class="layui-nav-item"  >
	  	<a href="${path }/personal#personal_message"><i class="layui-icon layui-icon-notice" style="font-size: 15px; "></i>&nbsp;消息<span id="header_message_count" class="layui-badge">0</span></a>
	  </li>
	  
	  <li id="cartPanel"  class="layui-nav-item"  >
	  	<a href="${path }/personal#personal_cart"><i class="layui-icon layui-icon-cart-simple" style="font-size: 15px; "></i>&nbsp;购物车<span id="header_cart_count" class="layui-badge">0</span></a>
	  </li> --%>
	  
	  <li id="userDropdownPanel" class="layui-nav-item" style="margin-right:50px;">
	  	<a href="javascript:;"> <img style='width: 42px;height: 42px;border-radius:50%;margin-right:3px;' src='${currentUser.headIcon }'/>${currentUser.username }</a>
	    <dl class="layui-nav-child"> <!-- 二级菜单 -->
	      <dd><a href="${path }/${currentUser.account}">个人中心</a></dd>
	      <dd><a id="btn_logout">注销登录</a></dd>
	    </dl>
	  </li>
	</ul>
</div>

	<script src="${path }/js/page/header.js"></script>
</html>