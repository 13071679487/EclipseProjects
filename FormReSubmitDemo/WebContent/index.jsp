<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rifu.util.TokenProcessor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% 
	pageContext.setAttribute("path", request.getContextPath());
%>
</head>
<body>

	<form action="${path }/test" method="post">
		<input type="hidden" name="COM.RIFU.TOKEN_KEY" value="<%=TokenProcessor.getInstance().saveToken(request)%>"/>
		name:<input type="text" name="name"/>
		<br>
		<input type="submit" value="login">&nbsp; <font color="red">${errorMsg }</font>
	</form>
</body>
</html>