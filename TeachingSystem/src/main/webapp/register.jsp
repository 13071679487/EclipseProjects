<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>

<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!-- web路径 
不以/开头的就是相对路径，以当前资源的路径为基准，找资源经常容易出问题
以/开头 的相对路径，找资源，以服务器的路径为标准（http:/localhost:3306）+需要加上项目名
-->


	<!-- 牢记，先引入js再引入css -->
<!-- 引入jquery -->
<link href="${path}/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${path}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 引入js文件 -->
<script
	src="${path }/bootstrap3/js/bootstrap.min.js"></script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-2 col-md-offset-3">
			<h4>账号注册</h4>
		</div>
		</div>
	</div>
	
	<div class="row">
		<div class="container">
			<div class="row jumbotron col-md-8 col-md-offset-2">
				<form class="form-horizontal">
				<!--Account  -->
				  <div class="form-group">
				    <label class="col-sm-2 control-label">账号</label>
				    <div class="col-sm-6">
				      <input id="rname" type="text" name="rname"class="form-control"  placeHolder="Please input name">
				      <span class="help-block"></span>
				    </div>
				  </div>
				  
				  <!--Password  -->
				  <div class="form-group">
				    <label class="col-sm-2 control-label">密码</label>
				    <div class="col-sm-6">
				      <input id="password" type="password" name="password"class="form-control"  placeHolder="Please input password">
				      <span class="help-block"></span>
				    </div>
				  </div>
				</form>
				  <div class="form-group" style="text-align: center;">
				  <a role="button" class="btn btn-primary" id="btn-register">注册</a>
				  </div>
			</div>
		</div>
	</div>
	
	
</div>

</body>
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">

$("#btn-register").on("click",function(){
	$.ajax({
		url:"${path}/addRole",
		type:"POST",
		data:{"rname":$("#rname").val(),"password":$("#password").val()},
		success:function(result){
			console.log(result);
			if(result.code==100){
				//注册成功
				console.log("result.extend.href:"+result.extend.href)
				location.href=result.extend.href;
			}else{
				console.log("result.extend.href:"+result.extend.href)
				location.href=result.extend.href;
			}
		},
		error:function(){
			
		}
	})
})
</script>
</html>