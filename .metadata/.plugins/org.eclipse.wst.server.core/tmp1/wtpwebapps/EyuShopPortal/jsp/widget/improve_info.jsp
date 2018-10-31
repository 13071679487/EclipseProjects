<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
				<div class="layui-card " style="border-radius:20px;background-color:rgba(255,255,255,.7);">
					  <div class="layui-card-header"><h4>完善信息</h4></div>
					  <div class="layui-card-body">
					    <form class="layui-form">
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-username" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
					    			<input  type="text" id="improve_info_userid" name="userId" style="display:none;">
							      <input  type="text"  name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-senior" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text"  name="email" required  lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-log" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       	<input type="radio" name="sex" value="m" title="男" checked>
      								<input type="radio" name="sex" value="f" title="女">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
						    	<div class="layui-input-block" style="margin:0;text-align: center;">
							      <button id="btn_complete" lay-submit lay-filter="btn_complete" class="layui-btn input-radius-20px" style="width:200px;">完成</button>
							    </div>
							  </div>
					    </form>
					  </div>
					</div>
</body>
</html>