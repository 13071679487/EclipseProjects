<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩单</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!-- web路径 
不以/开头的就是相对路径，以当前资源的路径为基准，找资源经常容易出问题
以/开头 的相对路径，找资源，以服务器的路径为标准（http:/localhost:3306）+需要加上项目名
-->
	<!-- 牢记，先引入js再引入css -->
<!-- 引入jquery -->
<link href="${path}/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${path}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 引入js文件 -->
<script
	src="${path }/bootstrap3/js/bootstrap.min.js"></script>
<style type="text/css">
.headSperator{
	border:2px dotted gray;
}
</style>
</head>
<body>
	<div class="container">
		<hr class="headSperator">
		<h3 style="text-align: center;">学生成绩单</h3>
		<hr class="headSperator">
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover table-condensed table-striped" id="users_table">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>课程代号</th>
							<th>课程名称</th>
							<th>成绩</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>2276</td>
							<td>黄理富</td>
							<td>aapp22</td>
							<td>大英</td>
							<td>100</td>
							<td>...</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td>aapp22</td>
							<td>大英</td>
							<td>100</td>
							<td>...</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>平均成绩：75&nbsp;绩点：4.0</td>
						<tr/>
						<tr>
							<td>1104</td>
							<td>练德锋</td>
							<td>aapp22</td>
							<td>大英</td>
							<td>100</td>
							<td>...</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	initTbcell();
})

function initTbcell(){
	$("tbody tr").children("td:last-child").prop({"style":"width:230px;"});
	
}
</script>
</html>