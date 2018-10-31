<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录到五邑商城</title>
</head>
<body style="background:url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529661511339&di=0e69460f6682ce775d86ec67fd9fe458&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F64%2F13%2F62H58PICjNc_1024.jpg);">
	<div class="layui-fluid">
		<div class="layui-row">
			<div class="layui-header layui-bg-green">
				<ul class="layui-nav  layui-bg-green" lay-filter="">
				  <li class="layui-nav-item">
					  <a >
						  <span class="logo">五邑商城后台管理系统</span>
					  </a>
				  </li>
				  </ul>
			</div>
		</div>
		
		<div class="layui-row">
			<div class="layui-card layui-col-md4 layui-col-md-offset4" style="margin-top:100px;border-radius:20px;background-color:rgba(255,255,255,.7);">
			  <div class="layui-card-header"><h4>登录</h4></div>
			  <div class="layui-card-body">
			    <div class="layui-form">
			    	<div class="layui-form-item">
			    		<label class="layui-form-label" ><i class="layui-icon layui-icon-username" style="font-size: 20px; color: #009688;"></i></label>
			    		<div class="layui-input-block">
					      <input type="text" id="input_account" name="account" required  lay-verify="required|phone" placeholder="请输入账号" autocomplete="off" class="layui-input input-radius-20px">
					    </div>
			    	</div>
			    	
			    	<div class="layui-form-item">
			    	<label class="layui-form-label" ><i class="layui-icon layui-icon-password" style="font-size: 20px; color: #009688;"></i></label>
			    		<div class="layui-input-block">
					      <input  type="password" id="input_password" name="password" required  lay-verify="required|pass" placeholder="请输入密码" autocomplete="off" class="layui-input input-radius-20px">
					    </div>
			    	</div>
			    	
			    	<div class="layui-form-item">
				    	<div class="layui-input-block" style="margin:0;text-align: center;">
					      <button id="btn_login" lay-submit lay-filter="*" type='submit' class="layui-btn input-radius-20px" style="width:200px;">登录</button>
					    </div>
					  </div>
					  
					  <div class="layui-form-item">
					    <div class="layui-input-block" style="margin:0;text-align: center;">
					      <a href="${path }/register" class="layui-layout-left" style="left:50px;">没有账号,先去注册一个...</a>
					      <a href="${path }/mp"class="layui-layout-right"  style="right:50px;">忘记密码?</a>
					    </div>
					  </div>
			    </div>
			  </div>
			</div>
		</div>
	</div>
</body>
<script src="${path }/js/manage/admin_login.js"></script>
</html>