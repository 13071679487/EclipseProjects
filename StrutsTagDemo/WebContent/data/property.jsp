<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.setAttribute("name","<font color=red>张三</font>");
%>
</head>
<body>
<s:property value="#request.name" /><br/>
<s:property value="#request.name2" default="某某人"/><br/>
<s:property value="#request.name" default="某某人" escapeHtml="false"/><br/>
</body>
</html>