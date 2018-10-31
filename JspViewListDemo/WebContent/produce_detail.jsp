<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,bean.Item,dao.ItemDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情页</title>
<style>
.floatBox{
float:left;
}
</style>
</head>
<body>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	ItemDao dao=new ItemDao();
	Item item=dao.getItemById(id);
%>

<div>
	<dl>
		<dt>
			<a href="javascript:;"><img src="images/<%=item.getItem_picture() %>" width="200" height="200"/></a>
		</dt>
		<dd><%=item.getItem_name() %></dd>
		<dd>库存:<%=item.getItem_number() %></dd>
		<dd>产地:<%=item.getItem_city() %> &nbsp;&nbsp;价格:＄<%=item.getItem_price() %></dd>
	</dl>
</div>
<h1>您浏览过的商品</h1>
<hr>
<%
	String list="";
	String[] arr;
	Cookie[] cookies=request.getCookies();
	for(Cookie c:cookies){
		if("isReadCookie".equals(c.getName())){
			list=c.getValue();
		}
	}
	arr=list.split(",");
	if(arr!=null&&arr.length>2){
		list="";
		for(int i=arr.length-2;i<arr.length;i++){
			list=","+arr[i]+list;
		}
		Cookie c=new Cookie("isReadCookie",list);
		response.addCookie(c);
	}
%>

<%
	ItemDao itemdao=new ItemDao();
	if(arr.length>0){
		for(int i=0;i<arr.length;i++){
			if(!arr[i].equals("")){
			Item it=itemdao.getItemById(Integer.parseInt(arr[i]));
%>
			<div class="floatBox">
				<dl>
					<dt>
						<a href="javascript:;"><img src="images/<%=it.getItem_picture() %>" width="200" height="200"/></a>
					</dt>
					<dd><%=it.getItem_name() %></dd>
					<dd>库存:<%=it.getItem_number() %></dd>
					<dd>产地:<%=it.getItem_city() %> &nbsp;&nbsp;价格:＄<%=it.getItem_price() %></dd>
				</dl>
			</div>
<%
			}
		}
	}
	list=","+id+list;
	Cookie c=new Cookie("isReadCookie",list);
	response.addCookie(c);
%>

</body>
</html>