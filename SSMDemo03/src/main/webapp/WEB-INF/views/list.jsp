<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!-- web路径 
不以/开头的就是相对路径，以当前资源的路径为基准，找资源经常容易出问题
以/开头 的相对路径，找资源，以服务器的路径为标准（http:/localhost:3306）+需要加上项目名
-->
<!-- 引入样式 -->
<link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 引入js文件 -->
<script src="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.js"></script>
<!-- 引入jquery -->
<script type="text/javascript"
	src="${path}/static/js/jquery-1.12.4.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12 page-header">
				<h1>Spring+SpringMVC+Mybatis</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-10">
				<button type="button" class="btn btn-primary">添加</button>
				<button type="button" class="btn btn-danger">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>Uid</th>
						<th>Name</th>
						<th>Gender</th>
						<th>Email</th>
						<th>Department</th>
						<th>Operation</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							 <td>${emp.empid }</td>
							<td>${emp.empname }</td>
							<td>${emp.gender=="n"?"男":"女" }</td>
							<td>${emp.email }</td>
							<td>${emp.dept.deptname }</td>
							<td>
								<button type="button" class="btn btn-warning btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
								</button>
								<button type="button" class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>删除
								</button>
							</td>
						</tr>
					</c:forEach> 
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				总${pageInfo.pages }
				页,总 ${pageInfo.total } 条记录
			</div>
			<div class="col-md-4 col-md-offset-1">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${path }/emps?pn=1" aria-label="First"> <span
							aria-hidden="true">First</span>
					</a></li>
					<c:if test="${pageInfo.hasPreviousPage }">
						<li><a href="${path }/emps?pn=${pageInfo.pageNum-1 }" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach items="${pageInfo.navigatepageNums }" var="pageNum">
						<c:if test="${pageNum==pageInfo.pageNum }">
							<li class="active"><a href="#"> ${pageNum }</a></li>
						</c:if>
						<c:if test="${pageNum!=pageInfo.pageNum }">
							<li ><a href="${path }/emps?pn=${pageNum }"> ${pageNum }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage }">
						<li><a href="${path }/emps?pn=${pageInfo.pageNum+1 }" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="${path }/emps?pn=${pageInfo.pages }" aria-label="Last"> <span
							aria-hidden="true">Last</span>
					</a></li>
				</ul>
				</nav>
			</div>

		</div>
	</div>

</body>
</html>