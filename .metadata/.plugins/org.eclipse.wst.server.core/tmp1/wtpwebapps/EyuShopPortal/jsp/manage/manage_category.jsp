<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
/* 	#category_table thead tr{
		padding:5px;
		background-color:#009688;
		color:rgba(250,250,250,.8);
	}
	#category_table tbody tr{
		color:rgba(100,100,100,.8);
		border-bottom:1px solid #ccc;
		padding:5px;
	}
	
	#category_table tbody tr td{
	text-align: center;
	} */
	
	</style>
</head>
		<div class="layui-row">
				<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
					<h4 style="color:rgba(80,80, 80, .7);">商品分类管理</h4>
				</div>
			</div>
			
			<div class="layui-row" style="margin-top:25px;">
				<table class='layui-table' id="category_table" lay-filter="category_table" style="width:100%;">
					<thead>
						<tr>
						      <th lay-data="{field:'categoryId', width:80, sort: true}">ID</th>
						      <th lay-data="{field:'categoryName', width:80}">名称</th>
						      <th lay-data="{field:'parentId', width:80, sort: true}">父节点</th>
						      <th lay-data="{field:'categoryStatus'}">状态</th>
						      <th lay-data="{field:'createTime'，sort: true}">创建时间</th>
						      <th lay-data="{field:'updateTime', sort: true}">更新时间</th>
						      <th lay-data="{field:'op'}">操作</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
			
			<div class="layui-row" style="text-align: center;margin-top:50px;">
				<button id="btn_createCategory" class="layui-btn input-radius-20px" style="width:200px;">新建标签</button>
			</div>
			
</html>