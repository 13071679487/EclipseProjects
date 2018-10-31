<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.rifu.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>使用javabean</title>
</head>
<body>
	<h1>javabean的使用</h1>
	<hr>
	<!--第一种方式创建javabean -->
	<%
		User user=new User();
		user.setUsername("admin");
		user.setPassword("123456");
	%>
	用户名：<%=user.getUsername() %><br>
	密码：<%=user.getPassword() %><br>
	<hr>
	<!--使用useBean动作方式创建javabean -->
	<jsp:useBean id="myuser" class="com.rifu.User" scope="page"/>
	<%
		myuser.setUsername("admin1");
		myuser.setPassword("123456");
	%>
	用户名：<%=myuser.getUsername() %><br>
	密码：<%=myuser.getPassword() %><br>
</body>
</html>