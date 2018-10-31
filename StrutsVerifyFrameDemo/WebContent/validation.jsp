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
用户注册
<s:form action="/validationAction" method="post">
	<s:textfield name="name" label="用户名"></s:textfield>
	
	<s:submit value="注册"></s:submit>
</s:form>
</body>
</html>