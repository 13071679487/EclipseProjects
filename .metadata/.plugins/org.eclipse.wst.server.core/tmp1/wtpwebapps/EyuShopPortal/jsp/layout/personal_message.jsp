<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<style type="text/css">
			.layui-card .layui-card-header{
				color:#fff;
				background-color:#009688;
				opcity:0.7;
			}
			.message-item{
				margin-top:15px;
			}
		</style>
	</head>
	<div class="layui-row">
		<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
			<h4 style="color:rgba(80,80, 80, .7);">消息</h4>
		</div>
	</div>
	
	<div id="message_content" class="layui-row">
		
		
	</div>
	
	<div class="layui-row" style="margin-top:50px;">
		<div class="layui-col-md12" style="text-align: center;">
			<button id="btn_deleteAllNotify" class="layui-btn layui-btn-danger input-radius-20px" style="width:200px;"> 删除所有消息</button>
		</div>
	</div>
	
	<div class="layui-row" style="margin-top:100px;">
			<jsp:include page="/jsp/widget/page_nav.jsp"></jsp:include>
	</div>
	
</html>