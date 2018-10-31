<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path=request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<html>
		<div class="layui-col-md10 layui-col-md-offset1">
				<ul id="category_nav" class="layui-nav layui-bg-green">
					
				</ul>
			</div>
			<script type="text/javascript" src="${path }/js/widget/category_nav.js"></script>
</html>