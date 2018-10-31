<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body style="text-align: center">
<jsp:include page="loader.jsp"></jsp:include>
<input type="button" id="btn_execute" value="计算"/><br>
面积:<input id="area" type="text"/>
</body>
<script type="text/javascript">
		$(function(){
			execute();
		})
		
		$("#btn_execute").on('click',function(){
			execute();
		})
		function execute(){
			var up=parseInt($("#up").val());
			var down=parseInt($("#down").val());
			var height=$("#height").val();
			$("#area").val((up+down)*height/2);
		}
		
		
	</script>

</html>