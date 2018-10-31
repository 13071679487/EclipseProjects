<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
</head>
<body style="padding: 20px">
<div>
  <div class="btn-group btn-group-justified">
    <a href="#" class="btn btn-default" role="button">Left</a>   
    <a href="#" class="btn btn-default" role="button">Middle</a>
    <a href="#" class="btn btn-default" role="button">Right</a>
  </div>
  <br>
  <div class="btn-group btn-group-justified">
    <a href="#" class="btn btn-default" role="button">Left</a>
    <a href="#" class="btn btn-default" role="button">Middle</a>
    <div class="btn-group">
      <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
        Dropdown <span class="caret"></span>
      </a>
      <ul class="dropdown-menu" role="menu">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li class="divider"></li>
        <li><a href="#">Separated link</a></li>
      </ul>
    </div>
  </div>
  <hr/>
  <div class="btn-group btn-group-justified">
     <div class="btn-group">
       <button type="button" class="btn btn-default">Left</button>
     </div>
     <div class="btn-group">
       <button type="button" class="btn btn-default">Middle</button>
     </div>
     <div class="btn-group">
       <button type="button" class="btn btn-default">Right</button>
     </div>
   </div>
</div>


</body>
</html>