<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path=request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<html>
		<div class="layui-col-md4 layui-col-md-offset4 input-search">
			<form action="${path }/products">
				<i class="layui-icon layui-icon-release layui-layout-left"
					style="font-size: 25px; height: 100%; left: 0; padding-top: 5px; width: 35px; text-align: center;"></i>
				<input type="text" name="key" placeholder="请输入搜索商品" autocomplete="off"
					class="layui-input" style="border: none; display: inline;" />
				<button id="btn_search" type="submit" class="layui-btn layui-layout-right"
					style="height: 100%; width: 64px; margin: 0; padding: 0; background-color: #009688; border-radius: 0 25px 25px 0 !important;">搜索</button>
			</form>
		</div>
		
</html>