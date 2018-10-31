<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
	
	</style>
</head>
		<div class="layui-row">
				<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
					<h4 style="color:rgba(80,80, 80, .7);">进出货管理</h4>
				</div>
			</div>
			
			<div class="layui-row" style="margin-top:25px;">
				<table class='layui-table' id="repertory_table" lay-filter="category_table" style="width:100%;">
					<thead>
						<tr>
						      <th >ID</th>
						      <th >产品编号</th>
						      <th >产品名称</th>
						      <th >数量</th>
						      <th >单位</th>
						      <th >单位价格</th>
						      <th >进/出</th>
						      <th >提供商</th>
						      <th >创建时间</th>
						      <th >更新时间</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
			
			<div class="layui-row" style="text-align: center;margin-top:50px;">
				<button id="btn_createRepertoryRecord" class="layui-btn input-radius-20px" style="width:200px;">添加纪录</button>
			</div>
			
			<div class="layui-row" style="margin-top:50px;">
				<jsp:include page="/jsp/widget/page_nav.jsp"></jsp:include>
			</div>
			
</html>