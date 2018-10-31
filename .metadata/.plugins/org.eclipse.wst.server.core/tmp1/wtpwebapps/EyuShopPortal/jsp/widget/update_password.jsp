<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
				<div class="layui-card " style="border-radius:20px;background-color:rgba(255,255,255,.7);">
					  <div class="layui-card-header"><h4>设置密码</h4></div>
					  <div class="layui-card-body">
					    <form class="layui-form">
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-password" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
					    			<input  type="text" id="update_pwd_account" name="account" style="display:none;">
							      <input  type="password" id="password" name="password" required  lay-verify="required"  placeholder="请输入密码" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-password" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							      <input  type="password" id="passwordrepeat" name="password" required  lay-verify="required"  placeholder="确认密码" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
						    	<div class="layui-input-block" style="margin:0;text-align: center;">
							      <button id="btn_toImproveInfo" lay-submit lay-filter="btn_toImproveInfo" class="layui-btn input-radius-20px" style="width:200px;">下一步</button>
							    </div>
							  </div>
					    </form>
					  </div>
					</div>
</body>
</html>