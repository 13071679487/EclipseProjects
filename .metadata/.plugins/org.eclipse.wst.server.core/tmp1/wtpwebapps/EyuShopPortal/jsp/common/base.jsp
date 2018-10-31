<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String path=request.getContextPath();
	pageContext.setAttribute("path", path);
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	pageContext.setAttribute("basepath", basePath);
%>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="https://getbootstrap.com/favicon.ico">

<script type="text/javascript"
	src="${path}/js/jquery-1.11.2.min.js"></script>
<!-- 引入js文件 -->
<script src="${path }/layui/layui.js"></script>
<script src="${path }/js/common.js"></script>
<!-- 引入样式 -->
<link href="${path}/layui/css/layui.css" rel="stylesheet">
<link href="${path}/css/common.css" rel="stylesheet">
