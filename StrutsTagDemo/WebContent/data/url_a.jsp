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
<s:url action="hello" namespace="/foreground" id="h">
	<s:param name="name" value="'struts2'"></s:param>
</s:url>
<s:a href="%{h}">超链接</s:a>

<s:a action="hello" namespace="/foreground">
	<s:param name="name" value="'struts2'"></s:param>
	超链接2
</s:a>
</body>
</html>