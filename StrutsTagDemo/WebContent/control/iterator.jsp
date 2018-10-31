<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.rifu.model.Student" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	List<Student> studentList=new ArrayList<Student>();
	studentList.add(new Student(1,"张三",10));
	studentList.add(new Student(3,"李四",20));
	studentList.add(new Student(5,"王五",30));
	request.setAttribute("studentList",studentList);
%>
</head>
<body>
<table>
	<tr>
		<th>序号</th>
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
	</tr>
	<s:iterator value="#request.studentList" status="status">
	<tr>
		<td><s:property value="#status.index+1"/></td>
		<td><s:property value="id"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="age"/></td>
	</tr>
	</s:iterator>
</table>
</body>
</html>