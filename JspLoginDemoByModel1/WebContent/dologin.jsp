<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<jsp:useBean id="loginUser" class="com.rifu.Users" />
<jsp:useBean id="userDao" class="com.dao.UserDao" />
<jsp:setProperty property="*" name="loginUser"/>/>
<%
	if(userDao.login(loginUser)){
		session.setAttribute("loginUser", loginUser.getUsername());
		request.getRequestDispatcher("login_success.jsp").forward(request, response);		
	}
	else{
		response.sendRedirect("login_fail.jsp");
	}
%>
