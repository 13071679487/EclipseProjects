<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	int age=11;
	request.setAttribute("age",age);
%>
</head>
<body>
<s:if test="#request.age<20">
	年龄小于20岁
</s:if>
<s:elseif test="#request.age==20">
	年龄等于20岁
</s:elseif>
<s:else>
	年龄大于20岁
</s:else>
</body>
</html>