<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<div class="child" style="width:500px;">
		<img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1671726633,343192533&fm=26&gp=0.jpg"/>
	</div>
	<div  class="child" style="width:300px;">
		<form action="dologin.jsp" method="post">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="提交"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>