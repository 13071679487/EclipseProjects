<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="listener.*" %>
    <%@ page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>统计当前在线人数</title>
</head>
<body>
<span>当前在线人数:</span>${onlineNum }
<%
	ArrayList<User> userList=(ArrayList<User>)request.getServletContext().getAttribute("userList");

	if(userList!=null){
		for(int i=0;i<userList.size();i++){
			User u=userList.get(i);
%>
	sessionID:<%=u.getSessionId() %>-----<%=u.getDate() %>
<%
		}
	}
%>
</body>
</html>