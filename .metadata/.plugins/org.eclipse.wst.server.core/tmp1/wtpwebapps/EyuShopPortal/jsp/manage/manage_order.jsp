<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
#category_table tbody ul li{
	display:inline-block;
	margin-left:2px;
}

</style>
</head>
			<div class="layui-row">
				<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
					<h4 style="color:rgba(80,80, 80, .7);">订单管理</h4>
				</div>
			</div>
			
			<div class="layui-row " style="margin-top:25px;">
					<div class="layui-col-md3" style="height:36px;background-color:#fff;border-radius:36px;border:1px solid #009688;">
						 <i class="layui-icon layui-icon-search" style="font-size:18px;color:#009688;"></i> 
						<input id="orderNo"  type="text" placeholder="请输入订单号" autocomplete="off"
						class="layui-input" style="height:100%;border: none;display:inline;" />
						<button id="btn_searchOrder" class="layui-btn  layui-btn-xs" style="height:100%;float:right;border:2px solid #fff;border-radius:0 36px 36px 0;display:inline;position:relative;">搜索</button>
					</div>
				</div>
			
			<div class="layui-row" style="margin-top:5px;">
				<table id="category_table" lay-filter="category_table" style="width:96%;" class='layui-table'>
					<thead>
						<tr>
						      <th lay-data="{field:'categoryId', width:80, sort: true}">订单编号</th>
						      <th lay-data="{field:'categoryName', width:80}">收件人</th>
						      <th lay-data="{field:'categoryName', width:80}">联系电话</th>
						      <th lay-data="{field:'parentId', width:80, sort: true}">订单金额</th>
						      <th lay-data="{field:'categoryStatus'}" style='width:98px; '>
						      	<select id='orderStatus_select'>
								  <option value ="-1">全部订单</option>
								  <option value ="10">未支付</option>
								  <option value="20">已付款</option>
								  <option value="40">已发货</option>
								  <option value="0">已取消</option>
								  <option value="60">已关闭</option>
								</select>
						      </th>
						      <th lay-data="{field:'createTime'，sort: true}">创建时间</th>
						      <th lay-data="{field:'op'}">操作</th>
						</tr>
					</thead>
					<tbody>
					
					
					</tbody>
				</table>
			</div>
			
			<div class="layui-row" style="margin-top:50px;">
				<jsp:include page="/jsp/widget/page_nav.jsp"></jsp:include>
			</div>
			
			<script>
			var currentPage;
			$(function(){
				manage_orderCallback();
			})

			/**
			 * 初始化函数
			 */
			function manage_orderCallback(){
				getOrderList(1,10,null,null);
			}
			</script>
			
</html>