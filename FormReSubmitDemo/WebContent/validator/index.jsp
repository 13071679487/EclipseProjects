<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rifu.util.TokenProcessor" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
	pageContext.setAttribute("path", request.getContextPath());
%>
	<!-- 牢记，先引入js再引入css -->
<!-- 引入jquery -->
<script type="text/javascript"
	src="${path}/static/js/jquery-1.12.4.min.js"></script>
<!-- 引入js文件 -->
<script
	src="${path }/bootstrap3/js/bootstrap.min.js"></script>
<!-- 引入样式 -->
<link href="${path}/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>

</head>
<body>

	<form action="${path }/testImageServlet" method="post">
		<input type="hidden" name="COM.RIFU.TOKEN_KEY" value="<%=TokenProcessor.getInstance().saveToken(request)%>"/>
		<br>
		name:<input type="text" name="name"/>
		<br>
		code:<input type="text" name="code">
				<img id="verifyCode" alt="" src="${path }/validateColorServlet">
				<input id="btn_toggle"type="button" value="换一个">
			<br>
		<input type="submit" value="login">&nbsp; <font color="red">${errorMsg }</font>
	</form>
	<script type="text/javascript">
	$("#btn_toggle").click(function(){
		var random=new Date().toString();
		$("#verifyCode").attr("src","${path }/validateColorServlet?"+random);
	});
	</script>
</body>
</html>