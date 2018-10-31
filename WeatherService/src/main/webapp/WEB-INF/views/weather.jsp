<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取天气</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>

<script type="text/javascript"
	src="${path}/js/jquery-1.11.2.min.js"></script>
</head>
<body>
	<div id=""></div>
</body>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"${path}/weather",
		type:"GET",
		success:function(result){
			console.log(result);
		}
	})
})
</script>
</html>