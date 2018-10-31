<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="dao.ItemDao" %>
    <%@ page import="bean.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path=request.getContextPath();
	int id=Integer.parseInt(request.getParameter("id"));
	ItemDao idao=new ItemDao();
	Item item=idao.getItemById(id);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>操作</title>
</head>
<body>
<h1>添加进购物车成功</h1>
<hr>
您以添加<%=item.getItem_name() %>共<%=request.getParameter("number") %>件
</body>
</html>