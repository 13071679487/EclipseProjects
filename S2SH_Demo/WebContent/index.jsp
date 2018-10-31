<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
S2SH!
<form action="${pageContext.request.contextPath }/user/user_login.action" method="post">
	userName:<input type="text" name="user.userName" value="${user.userName }"/><br/>
	password:<input type="password" name="user.password" value="${user.password }"/><br/>
	<input type="submit" value="login"/><font color="red">${error}</font>
</form>
</body>
</html>