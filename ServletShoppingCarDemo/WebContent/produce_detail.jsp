<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*,bean.Item,dao.ItemDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int id = Integer.parseInt(request.getParameter("id"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情页</title>
<style>
.btn_border {
	backgroundColor: yellow;
	border: 1px solid #F5F5DC;
	border_radius: 5px;
}

.floatBox {
	float: left;
}
</style>
<script>
	window.onload = function() {
		var sub = document.getElementById('sub');
		var add = document.getElementById('add');
		var addToCart = document.getElementById('addToCart');
		addToCart.onclick = function() {
			var num = document.getElementById('number');
			var number = parseInt(num.value);
			var form=document.createElement("form");
		 	form.action="servlet/CartServlet?id=<%=id%>&number="+number+"&action=add";
			form.method="post";
			form.submit();
		
		
			/*该方法没有起作用
			$.ajax({ 
			    type : "POST", 
			    url : "<%=path%>/servlet/CartServlet?id=<%=id%>&number="+number+"&action=add",
			    success : function(result) { 
					alert('加入购物车成功');
			    }
			});
			*/
			alert('加入购物车成功');
		}
		sub.onclick = function() {
			var num = document.getElementById('number');
			var number = parseInt(num.value);
			if (number > 1) {
				number--;
				num.value = number;
			}
		}
		add.onclick = function() {
			var num = document.getElementById('number');
			var number = parseInt(num.value);
			number++;
			num.value = number;
		}
	}
</script>
</head>
<body>
	<%
		ItemDao dao = new ItemDao();
		Item item = dao.getItemById(id);
	%>

	<div>
		<dl>
			<dt>
				<a href="javascript:;"><img
					src="images/<%=item.getItem_picture()%>" width="200" height="200" /></a>
			</dt>
			<dd><%=item.getItem_name()%></dd>
			<dd>
				库存:<%=item.getItem_number()%></dd>
			<dd>
				产地:<%=item.getItem_city()%>
				&nbsp;&nbsp;价格:＄<%=item.getItem_price()%></dd>
		</dl>
		<input id="sub" type="button" value="-" /> <input id="number"
			type="text" value="1" style="width: 25px;" /> <input id="add"
			type="button" value="+" /><br> <input id="addToCart"
			class="btn_border" type="button" value="加入购物车" /> <a
			href="servlet/CartServlet?action=show"><input class="btn_border"
			type="button" value="查看购物车" /></a>
	</div>
	<h1>您浏览过的商品</h1>
	<hr>
	<%
		String list = "";
		String[] arr;
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if ("isReadCookie".equals(c.getName())) {
				list = c.getValue();
			}
		}
		arr = list.split(",");
		if (arr != null && arr.length > 2) {
			list = "";
			for (int i = 0; i < arr.length - 1; i++) {
				list = "," + arr[i] + list;
			}
			Cookie c = new Cookie("isReadCookie", list);
			response.addCookie(c);
		}
	%>

	<%
		ItemDao itemdao = new ItemDao();
		if (arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (!arr[i].equals("")) {
					Item it = itemdao.getItemById(Integer.parseInt(arr[i]));
	%>
	<div class="floatBox">
		<dl>
			<dt>
				<a href="javascript:;"><img
					src="images/<%=it.getItem_picture()%>" width="200" height="200" /></a>
			</dt>
			<dd><%=it.getItem_name()%></dd>
			<dd>
				库存:<%=it.getItem_number()%></dd>
			<dd>
				产地:<%=it.getItem_city()%>
				&nbsp;&nbsp;价格:＄<%=it.getItem_price()%></dd>
		</dl>
	</div>
	<%
		}
			}
		}
		list = "," + id + list;
		Cookie c = new Cookie("isReadCookie", list);
		response.addCookie(c);
	%>

</body>
</html>