<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息修改</title>
</head>
<body>
				<form class="layui-form" action="" style="margin-top:25px;">
			    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-username" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							      <input  type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-senior" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" name="email" required  lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input input-radius-20px">
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
					      <button class="layui-btn input-radius-20px" style="width:200px;">确认修改</button>
					    </div>
					  </div>
					  
			    </form>
</body>
<script type="text/javascript">
layui.use('element', function(){
	  element = layui.element;
	  
	});

	layui.use('form', function(){
		  var form = layui.form;
		  
	});
</script>
</html>