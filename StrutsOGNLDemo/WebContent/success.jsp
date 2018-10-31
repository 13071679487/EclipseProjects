<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OGNL</title>
<%
	request.setAttribute("name", "李四(request)");
	request.setAttribute("age", "12");
%>
</head>
<body>
获取狭义上的值栈数据：<s:property value="name"/>
<s:property value="age"/><br/>
请求参数：<s:property value="#parameters.name"/>
<s:property value="#parameters.age"/><br/>
request：<s:property value="#request.name"/>
<s:property value="#request.age"/><br/>
session：<s:property value="#session.name"/>
<s:property value="#session.age"/><br/>
application：<s:property value="#application.name"/>
<s:property value="#application.age"/><br/>

<!-- attr取值的顺序为page request session application -->
attr取值：<s:property value="#attr.name"/>
<s:property value="#attr.age"/><br/>

OGNL取javabean的属性值：<s:property value="user.name"/>
<s:property value="user.age"/><br/>

OGNL取javabean的List集合：<s:property value="users[0].name"/>
<s:property value="users[0].age"/><br/>
<s:property value="users[1].name"/>
<s:property value="users[1].age"/><br/>

OGNL取javabean的Map集合：<s:property value="userMap['good'].name"/>
<s:property value="userMap['good'].age"/><br/>
<s:property value="userMap['bad'].name"/>
<s:property value="userMap['bad'].age"/><br/>
</body>
</html>