<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="/EyuShopPortal/css/personal_order.css" rel="stylesheet">
</head>
	<div class="layui-row">
		<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
			<h4 style="color:rgba(80,80, 80, .7);">我的订单</h4>
		</div>
	</div>
	
	<div id="order_nav" class="layui-row" style="margin-top:15px;">
		<ul style="width:100%;height:30px;">
			<li id="order_all" class="order_nav_item">全部订单</li>
			<li id="order_nopay" class="order_nav_item">未付款</li>
			<li id="order_wait" class="order_nav_item">待收货</li>
			<li id="order_finish" class="order_nav_item">已完成</li> 
			<li style="float:right;">
				<div class="layui-row " >
					<div class="layui-col-md12" style="height:25px;background-color:#fff;border-radius:25px;border:1px solid #009688;">
						 <i class="layui-icon layui-icon-search" style="font-size:18px;color:#009688;"></i> 
						<input id="orderNo"  type="text" placeholder="请输入订单号" autocomplete="off"
						class="layui-input" style="height:auto;border: none;display:inline;" />
						<button id="btn_searchOrder" class="layui-btn  layui-btn-xs" style="height:100%;float:right;border:2px solid #fff;border-radius:0 25px 25px 0;display:inline;position:relative;top:-21px;">搜索</button>
					</div>
				</div>
			</li>
		</ul>
	</div>
	
	<div class="layui-row" style="margin-top:15px;margin-bottom:25px;">
		<jsp:include page="/jsp/widget/page_nav.jsp"></jsp:include>
	</div>
	
	<script type="text/javascript"
	src="/EyuShopPortal//js/layout/personal_order.js"></script>	
	
</html>