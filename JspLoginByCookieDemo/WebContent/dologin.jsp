<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page import="java.net.*"%>
<h1 align="center">登陆成功</h1>
<hr>
<%
	request.setCharacterEncoding("utf-8");
	String[] isRemenber=request.getParameterValues("remember");
	if(isRemenber!=null&&isRemenber.length>0){
		//避免保存数据时出现编码的问题，使用URLEncoder进行编码
		String username=URLEncoder.encode(request.getParameter("username"), "utf-8");
		String password=URLEncoder.encode(request.getParameter("password"), "utf-8");
		Cookie usernameCookie=new Cookie("username",username);
		Cookie passwordCookie=new Cookie("password",password);
		usernameCookie.setMaxAge(604800);  //设置生命为7天
		passwordCookie.setMaxAge(604800);
		response.addCookie(usernameCookie);
		response.addCookie(passwordCookie);
		pageContext.include("login_success.jsp");
	}else{
		//删除原先保存的账号密码
		Cookie[] cookies=request.getCookies();
		if(cookies!=null&&cookies.length>0){
			for(Cookie c:cookies){
				if("username".equals(c.getName())||"password".equals(c.getName())){
					c.setMaxAge(0);
					response.addCookie(c);         //设置完生命时间后要重新Add进response
				}
			}
		}
		
	}
%>
