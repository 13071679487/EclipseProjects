<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:actionerror/>
<form action="student" method="post" >
	<s:token></s:token>
	姓名：<input type="text" name="student.name"/><br/>
	年龄：<input type="text" name="student.age"/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>