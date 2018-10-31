<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>dologin</title>
</head>
<body >
<jsp:useBean id="myuser" class="com.rifu.User" scope="page"/>
<h1>setProperty动作元素</h1>
<hr>
<!--根据表单自动匹配属性  -->
<jsp:setProperty property="*" name="myuser"/>
用户名：<%=myuser.getUsername() %><br>
密码：<%=myuser.getPassword() %><br>
</body>
</html>