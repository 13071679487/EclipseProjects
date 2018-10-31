<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:bean name="com.rifu.model.Student" var="student">
	<s:param name="name" value="'张三'"></s:param>
	<s:param name="age" value="10"></s:param>
</s:bean> 
<s:property value="#student.name"/>
<s:property value="#student.age"/>
</body>
</html>