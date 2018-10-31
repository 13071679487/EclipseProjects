<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="entity.Users" %>
    <%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息页面</title>
</head>
<body>
 <h1>详情页面</h1>
 <hr>
<%
	request.setCharacterEncoding("utf-8");
	Users u=(Users)request.getSession().getAttribute("regUser");
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
账号:<%=u.getUsername() %><br>
密码:<%=u.getPassword() %><br>
性别:<%=u.getSex() %><br>
出生日期:<%=sdf.format(u.getBirthday()) %><br>
爱好:<%
	String[] hobbies=u.getHobbies();
	for(String h:hobbies){
		out.print(h+"&nbsp;&nbsp;");
	}
%>

</body>
</html>