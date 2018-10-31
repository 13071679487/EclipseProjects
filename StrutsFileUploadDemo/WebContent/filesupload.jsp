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
文件上传
<s:fielderror></s:fielderror>
<form action="uploads" method="post" enctype="multipart/form-data">
	文件：<input type="file" name="rifu"/><br/>
	文件：<input type="file" name="rifu"/><br/>
	文件：<input type="file" name="rifu"/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>