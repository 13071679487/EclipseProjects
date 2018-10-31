<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>完善个人资料</title>

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
			<h4>1.账号注册</h4>
		</div>
		<div class="col-md-2">
			<h4>2.完善个人资料</h4>
		</div>
		<div class="col-md-2">
			<h4>3.注册完成</h4>
		</div>
	</div>

	<div class="row">
		<div class="progress col-md-6 col-md-offset-3">
		  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
		    <span class="sr-only">40% Complete (success)</span>
		  </div>
		</div>
	</div>
	
	<div class="row">
		<div class="container">
			<div class="row jumbotron col-md-8 col-md-offset-2">
				<form class="form-horizontal" id="updateInfoForm">
				<!--Name  -->
				  <div class="form-group">
				    <label class="col-sm-2 control-label">Name</label>
				    <div class="col-sm-6">
				      <input type="text" name="userName"class="form-control" id="input_name" placeHolder="Please input name">
				      <span class="help-block"></span>
				    </div>
				  </div>
				  
				  <!-- Email -->
				  <div class="form-group">
				    <label class="col-sm-2 control-label">Email</label>
				    <div class="col-sm-8">
				      <input type="email" name="userEmail" class="form-control" id="input_email" placeHolder="Please input email">
				      <span class="help-block"></span>
				    </div>
				  </div>
				  
				  <!-- Address -->
				  <div class="form-group">
				    <label class="col-sm-2 control-label">Address</label>
				    <div class="col-sm-8">
				      <input type="text" name="userAddress" class="form-control" id="input_address" placeHolder="Please input address">
				      <span class="help-block"></span>
				    </div>
				  </div>
				  
				  <!-- gender -->
				  <div class="form-group">
				    <label class="col-sm-2 control-label">Gender</label>
				    <div class="col-sm-10">
				      <label class="radio-inline">
						  <input type="radio" name="userGender" id="gender1_add_input" value="m" checked="checked"> 男
						</label>
						<label class="radio-inline">
						  <input type="radio" name="userGender" id="gender2_add_input" value="f"> 女
						</label>
				    </div>
				  </div>
				  
				  <!-- Description -->
				  <div class="form-group">
				    <label class="col-sm-2 control-label">Description</label>
				    <div class="col-sm-10">
				      <textarea name="userDesc"  id="input_desc" class="form-control" rows="3" placeHolder="Please input description"></textarea>
				      <span class="help-block"></span>
				    </div>
				  </div>
				  <div class="form-group" style="text-align: center;">
					  <button type="button" id="btn_commit" class="btn btn-primary" >提交</button>
				  </div>
				</form>
			</div>
		</div>
	</div>
	
	
</div>



</body>
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">

$("#btn_commit").on("click",function(){
	$.ajax({
		url:"",
		type:"POST",
		data:$("#updateInfoForm").serialize()+"",
		success:function(result){
			if(result.code==100){
				var url="${path}/dispatcher/registercomplete";
				console.log(url);
				$(location).prop("href",url);
			}
		}
		
	})
})
</script>
</html>