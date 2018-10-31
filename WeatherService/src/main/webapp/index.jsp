<%@page import="com.rifu.util.HtmlParseUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取地址</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>

<script type="text/javascript"
	src="${path}/js/jquery-1.11.2.min.js"></script>
</head>
<body>
	<div id="result"></div>
</body>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"http://ip.taobao.com/service/getIpInfo.php",
		data:{"ip":"myip","callback":null},
		type:"GET",
		dataType:'JSONP', 
		success:function(result){
			var json=eval("("+result+")");
			if(json.code==0){
				$("#result").empty().append(json.data);
			}else{
				$("#result").empty().append("获取失败");
			}
		}
	})
})
</script>
</html>