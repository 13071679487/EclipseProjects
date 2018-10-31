<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="dao.ItemDao"%>
<%@ page import="bean.Item"%>
<%@ page import="bean.Cart"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	Cart cart = null;
	if (request.getSession().getAttribute("cart") != null) {
		cart = (Cart) request.getSession().getAttribute("cart");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车列表</title>

<style>
table tr td {
	align: center;
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>我的购物车</h1>
	<table>
		<tr>
			<td colspan="2">商品</td>
			<td colspan="1">商品名字</td>
			<td colspan="1">商品数量</td>
			<td colspan="1">商品单价</td>
			<td colspan="1">总计</td>
		</tr>
		<%
			if (cart != null) {
				Set<Item> keys = cart.getGoods().keySet();
				Iterator<Item> it = keys.iterator();
				while (it.hasNext()) {
					Item item = it.next();
		%>
		<tr>
			<td colspan="2"><img src="images/<%=item.getItem_picture()%>" width="100" height="50"/></td>
			<td colspan="1"><%=item.getItem_name()%></td>
			<td colspan="1"><%=cart.getGoods().get(item)%></td>
			<td colspan="1"><%=item.getItem_price()%></td>
			<td colspan="1"><%=cart.getGoods().get(item) * item.getItem_price()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>