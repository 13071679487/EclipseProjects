<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	
<style type="text/css">
.studentIcon{
	width:150px;
	height:220px;
	border-radius:5px;
	position:absolute;
	right:40px;
	top:30px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="text-align: center;">
			<div class="col-md-1 col-md-offset-3" style="padding:0;margin:0;margin-left:30%;text-align: right;width:100px;">
				<select class="form-control" style="padding:0 10px;">
					<option value="1">教师编号</option>
				</select>
			</div>
			<div class="col-md-2" style="padding:0;margin:0;text-align: left;">
				<div class="input-group" >
			      <input type="text" class="form-control" id="searchCondition"/>
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button">搜索</button>
			      </span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3" style="position:relative;">
			<form class="form-horizontal"style="border:3px solid #eee;border-radius:5px;margin-top:20px;padding-top:10px;">
			<!-- ID -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">教师编号</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="input_account">
			    </div>
			  </div>
			  <!-- 姓名 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">教师姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="input_studentname">
			    </div>
			  </div>
			  <!-- 性别 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">性别</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="input_studentGender">
			    </div>
			  </div>
			  
			   <!-- 宿舍电话 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">职称</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="input_studentGender">
			    </div>
			  </div>
			  
			</form>
			</div>
		</div>
	</div>
</body>
</html>