<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,bean.Item,dao.ItemDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人商城</title>
</head>
<body>
<%=path %>
<table width="800" height="200" cellpadding="0" cellspacing="0">
	<tr>
		<%
			ItemDao dao=new ItemDao();
			ArrayList<Item> items=dao.getAllItem();
			if(items!=null&&items.size()>0)
			{
				for(int i=0;i<items.size();i++){
					Item item=items.get(i);
		%>
		<td>
		
			<div>
				<dl>
					<dt>
						<a href="produce_detail.jsp?id=<%=item.getId() %>" target="_blank"><img src="images/<%=item.getItem_picture() %>" width="200" height="200"/></a>
					</dt>
					<dd><%=item.getItem_name() %></dd>
					<dd>库存:<%=item.getItem_number() %></dd>
					<dd>产地:<%=item.getItem_city() %> &nbsp;&nbsp;价格:＄<%=item.getItem_price() %></dd>
				</dl>
			</div>
		</td>
		<%
				}
			}
		%>
	</tr>
</table>

</body>
</html>