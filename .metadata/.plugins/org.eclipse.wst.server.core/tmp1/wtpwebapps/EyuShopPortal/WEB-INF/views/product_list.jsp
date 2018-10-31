<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五邑商城</title>
<link href="${path}/css/product_list.css" rel="stylesheet">

<style type="text/css">
	.product-item img{
		width:100px;
		height:120px;
	}
	.sort_nav_item{
		cursor:pointer;
	}
	
</style>
</head>
<body>
	<div class="layui-fluid">
		<!-- nav bar  -->
		<div class="layui-row">
			<jsp:include page="/jsp/common/header.jsp"></jsp:include>
		</div>

		<!-- search bar -->
		<div class="layui-row" style="padding: 20px; text-align: center">
			<jsp:include page="/jsp/widget/search_bar.jsp"></jsp:include>
		</div>

		<!--  category items -->
		<div class="layui-row">
			<jsp:include page="/jsp/widget/category_nav.jsp"></jsp:include>
		</div>
		
		<!-- product toolbar -->
		<div id="product-toolbar" class="layui-row" style="margin-top:15px;">
			<div class="layui-col-md10 layui-col-md-offset1" style="background-color:rgba(220,220,220,.8);padding:5px;">
				<ul >
					<li class="sort_nav_item" id="sort_default">综合排序</li>
					<!-- <li>销量</li> -->
					<li class="sort_nav_item" id="sort_price">价格</li>
					<li style="float:right;padding-right:15px;position:relative;">
						<button  id="btn_screen" class="layui-btn layui-btn-xs"><i class="layui-icon layui-icon-app"></i>筛选</button>
						<div id="screen_panel" style=""> <!-- 二级菜单 -->
					      	<div class="layui-row" style="padding:15px 0;">
					      		<span>价格区间：</span>
					      		<input id="lowPrice" type="text" class="layui-input" style="display:inline;width:42px;height:25px;"/>
					      		:
					      		<input id="highPrice" type="text" class="layui-input" style="display:inline;width:42px;height:25px;"/>
					      	</div>
					      	
					      	<div class="layui-row">
					      		<button id="btn_ensureScreen" class="layui-btn" style="">确定</button>
					      	</div>
					    </div>
					</li>
				</ul>
			</div>
		</div>

		<!-- product list  -->
		<div id="product-list" class="layui-row">
			<div class="layui-col-md10 layui-col-md-offset1">
				<ul >
				</ul>
			</div>
		</div>

		<!-- page_nav -->
		<div  class="layui-row" style="margin-top:15px;">
			<div class="layui-col-md10 layui-col-md-offset1">
				<jsp:include page="/jsp/widget/page_nav.jsp"></jsp:include>
			</div>
		</div>
		
		<div class="layui-row" style="margin-top:15px;">
				<jsp:include page="/jsp/modules/module_guess_you_like.jsp"></jsp:include>
		</div>
		
		<div class="layui-row" style="margin-top:15px;">
			<jsp:include page="/jsp/common/footer.jsp"></jsp:include>
		</div>

	</div>
	
	<div>
		<jsp:include page="/jsp/widget/global_toolbar.jsp"></jsp:include>
	</div>
</body>
<script src="${path }/js/page/product_list.js"></script>
</html>