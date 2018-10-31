<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生情况报表</title>
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
.headSperator{
	border:2px dotted gray;
}

.itemSperator{
	border:1px solid #777;
	margin:15px 40px;
}
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
	<div class="container">
		<hr class="headSperator">
		<h3 style="text-align: center;">学生情况报表</h3>
		<hr class="headSperator">
		
		<div class="row">
			<div class="col-md-10 col-md-offset-1" style="position:relative;">
			<img class="studentIcon" alt="" src="http://p1.so.qhimgs1.com/bdr/326__/t01780cfa69f094efad.jpg"/>
			<form class="form-horizontal"style="border:3px solid #eee;border-radius:5px;margin-top:20px;padding-top:10px;">
			<!-- ID -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">学生学号：</label>
			    <label class="control-label" id="number">3115001104</label>
			  </div>
			  <!-- 姓名 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">学生姓名：</label>
			    <label class="control-label" id="name">练德锋</label>
			  </div>
			  <!-- 性别 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">学生性别：</label>
			    <label class="control-label" id="sex">男</label>
			  </div>
			  <!-- 生日 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">出生日期：</label>
			    <label class="control-label" id="birth">0000-00-00</label>
			  </div>
			  
			  <!-- 生源地 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">生源地：</label>
			    <label class="control-label" id="address">云浮</label>
			  </div>
			  
			  <!-- 政治面貌 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">政治面貌：</label>
			    <label class="control-label" id="politics">团员</label>
			  </div>
			  
			  <!-- 是否住宿 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">是否住宿：</label>
			    <label class="control-label" id="stay">是</label>
			  </div>
			  
			   <!-- 宿舍电话 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">宿舍电话：</label>
			    <label class="control-label" id="phone">1104</label>
			  </div>
			  
			</form>
			</div>
		</div>
		<hr class="itemSperator">
	</div>
</body>
<script type="text/javascript">
$(function(){
	initTbcell();
})

function initTbcell(){
	$("tbody tr").children("td:last-child").prop({"style":"width:230px;"});
	
}
</script>
</html>