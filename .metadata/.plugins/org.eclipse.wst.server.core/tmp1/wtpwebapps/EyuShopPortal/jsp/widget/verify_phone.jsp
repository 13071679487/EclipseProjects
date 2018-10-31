<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<div class="layui-card " style="border-radius:20px;background-color:rgba(255,255,255,.7);">
			  <div class="layui-card-header"><h4>手机号验证</h4></div>
			  <div class="layui-card-body">
			    <form class="layui-form">
			    
			    	<div class="layui-form-item">
			    		<label class="layui-form-label" ><i class="layui-icon layui-icon-username" style="font-size: 20px; color: #009688;"></i></label>
			    		<div class="layui-input-block">
					      <input type="tel" id="account" name="account" required  lay-verify="required"  placeholder="请输入账号" autocomplete="off" class="layui-input input-radius-20px">
					    </div>
			    	</div>
			    	
			    	<div class="layui-form-item">
			    	<label class="layui-form-label" ><i class="layui-icon layui-icon-vercode" style="font-size: 20px; color: #009688;"></i></label>
			    		<div class="layui-input-inline" style="width:140px;">
					      <input  type="text" id="verifycode" name="verifycode"  placeholder="请输入验证码" autocomplete="off" class="layui-input input-radius-20px"/>
					    </div>
					    <div class="layui-form-mid layui-word-aux" style="padding:0 !important;">
							<button id='btn_code' class="layui-btn layui-btn-normal layui-btn-sm">获取验证码</button>
						</div>
			    	</div>
			    	
			    	<div class="layui-form-item ">
				    	<div class="layui-input-block" style="margin:0;text-align: center;">
					      <button  id="btn_toSetPassword" lay-submit lay-filter="btn_toSetPassword" class="layui-btn input-radius-20px" style="width:200px;">下一步</button>
					    </div>
					  </div>
			    </form>
			  </div>
			</div>
</html>