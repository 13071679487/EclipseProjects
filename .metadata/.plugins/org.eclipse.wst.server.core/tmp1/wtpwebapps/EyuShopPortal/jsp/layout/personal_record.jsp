<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#record_content .record-item img{
	width:64px;
	height:72px;
}
#record_table{
	border-left:0;
	border-right:0;
}


</style>
</head>
		<div class="layui-row">
			<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
				<h4 style="color:rgba(80,80, 80, .7);">浏览记录</h4>
			</div>
		</div>
		
		<div id="record_content" class="layui-row" style="margin-top:50px;">
			<table id='record_table' class='layui-table' lay-skin="line">
				
			</table>
		</div>
		
		<div class="layui-row" style="margin-top:50px;">
		<div class="layui-col-md12" style="text-align: center;">
			<button id="btn_deleteAllRecord" class="layui-btn layui-btn-danger input-radius-20px" style="width:200px;"> 清空所有记录</button>
		</div>
	</div>
		
		<div class="layui-row" style="margin-top:100px;">
			<jsp:include page="/jsp/widget/page_nav.jsp"></jsp:include>
		</div>
		
		<script type="text/javascript"
	src="/EyuShopPortal/js/layout/personal_record.js"></script>	
</html>