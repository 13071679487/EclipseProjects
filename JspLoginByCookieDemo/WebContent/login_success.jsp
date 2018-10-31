<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import="java.util.*,java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User login</title>
<style>
.parent{
width:100%;
height:100%;
position:relative;
}
.child{
width:50%;
height:50%;
left:0;
right:0;
margin:0 auto;
}

</style>
<script>

</script>
</head>
<body class="parent">
	<div class="child">
		<img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1671726633,343192533&fm=26&gp=0.jpg"/>
	</div>
	<div  class="child">
	<%
	request.setCharacterEncoding("utf-8");
		String username="";
		String password="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null&&cookies.length>0){
			for(Cookie c:cookies){
				if("username".equals(c.getName())){
					username=URLDecoder.decode(c.getValue(), "utf-8");
				}
				if("password".equals(c.getName())){
					password=URLDecoder.decode(c.getValue(), "utf-8");
				}
			}
		}
	%>
		用户名:<%=username %><br>
		密码:<%=password %><br>
	</div>
</body>
</html>