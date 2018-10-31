<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>
<form action="servlet/RegServlet" method="post">
账号:<input type="text" name="username"></input><br>
密码:<input type="password" name="password"></input><br>
性别:<input type="radio" name="sex" value="男" checked="checked"/>男<input type="radio" name="sex" value="女"/>女<br>
 出生日期:<input name="birthday" type="date" /><br>
爱好:<input type="checkbox" name="hobby" value="电影"/>电影<input type="checkbox" name="hobby"value="音乐"/>音乐<input type="checkbox" name="hobby" value="上网"/>上网<br>
<input type="submit" value="注册">
</form>

</body>
</html>