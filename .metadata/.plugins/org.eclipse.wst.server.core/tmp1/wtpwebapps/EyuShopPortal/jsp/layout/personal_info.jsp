<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
 #personal_headicon{
 	cursor:pointer;
 }
</style>
</head>
	<div class="layui-row">
		<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
			<h4 style="color:rgba(80,80, 80, .7);">个人资料</h4>
		</div>
	</div>

	<div class="layui-row" style="margin-top:15px;">
		<div class="layui-col-md5" style="padding:10px;text-align: center;background-color:#5FB878;border-radius:40px 0 0 40px;height:120px;">
				<img id="personal_headicon" style="border:5px solid #ccc;width:64px;height:64px;" class="layui-circle" alt="" src="">
				<h4 id="personal_username" style="color:#ddd;margin-top:10px;"></h4>
			</div>
		<div class="layui-col-md5" style="color:#ddd;padding:15px;margin-left:15px;background-color:#5FB878;border-radius:0 40px 40px 0;">
			账号:<h4 id="personal_account" style="display:inline"></h4><br><br>
			性别:<h4 id="personal_gender"style="display:inline"><i class="layui-icon" style="font-size:20px;color:#01AAED"></i></h4>
		</div>
	</div>
	
	<div class="layui-row">
		<div class="layui-col-md5 layui-col-md-offset2" style="color:#ddd;padding:15px;margin-top:15px;background-color:#5FB878;border-radius:40px 0;">
			邮箱:<h4 id="personal_email" style="display:inline"></h4><br><br>
			地址:<h4 id="personal_address" style="display:inline"></h4>
		</div>
	</div>
	
	<div class="layui-row" style="margin-top:100px;padding:10px;text-align: center;">
		<button id="btn_updateModal" class="layui-btn input-radius-20px" style="width:200px;">编辑资料</button>
	</div>
	
</html>