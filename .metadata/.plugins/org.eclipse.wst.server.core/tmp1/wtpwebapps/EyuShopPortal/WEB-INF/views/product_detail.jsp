<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>

<style type="text/css">
#product-item ul{
	list-style:none;
}
#product-item ul li{
	list-style:none;
	display:inline;
	padding:2px;
}

#subimages{
	height:52px;
}
#subimages img:hover{
	border:2px solid #f00;
}

#foreground{
	width:300px;
	height:360px;
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

		<!-- product  title  -->
		<div id="product-item" class="layui-row" style="margin-top:15px;padding:0 5px;">
			<div class="layui-col-md10 layui-col-md-offset1">
				<div class="layui-row">
					<div class="layui-col-md4">
						<div class="layui-row">
							<img id="foreground" alt=""  />
						</div>
						<div class="layui-row" style="margin-top:10px;">
							<ul id="subimages">
							</ul>
						</div>
					</div>
					
					<div class="layui-col-md8">
						<h3 id="productName" style="color:#333"></h3>
						<h5 id="subtitle"></h5>
							
						<hr class="layui-bg-green">
						
						<div class="layui-row">
							单价：
							<span id="price"  style="color:#FF5722;font-size:16px;"></span>
						</div>
						
						<div class="layui-row" style="margin-top:15px;">
							库存：
							<span id="stock"  style="color:#FF5722;font-size:16px;"></span>
						</div>
						
						<div class="layui-row" style="margin-top:15px;">
							数量：
							<button id="btn_minus" class="layui-btn" style="background:none;border:none;color:#009688;font-size:25px">-</button>
							<input id="quantity" type="text" style="border:1px solid #009688;height:24px;width:32px;" value="1" />
							<button id="btn_plus" class="layui-btn" style="background:none;border:none;color:#009688;font-size:25px">+</button>
						</div>
						
						<div class="layui-row" style="margin-top:15px;">
							<button id="btn_addToCart" class="layui-btn" style="width:200px;background-color:#CD0000">加入购物车</button>
						</div>
						
					</div>
				</div>
			</div>
		</div>

		<!-- product detail -->
		<div  class="layui-row" style="margin-top:15px;padding:0 5px;">
			<div class="layui-col-md10 layui-col-md-offset1">
				<div class="layui-row">
					<span style="font-size:16px;color:#cff;background-color:#CD0000;padding:5px 15px;">商品详情</span>
					<hr style="margin-top:5px;" class="layui-bg-red">
				</div>
				<div id="product_detail" class="layui-row">
					
				</div>
			</div>
		</div>
		
		<div>
			<jsp:include page="/jsp/widget/global_toolbar.jsp"></jsp:include>
		</div>
		
		<div class="layui-row">
			<jsp:include page="/jsp/common/footer.jsp"></jsp:include>
		</div>

	</div>
</body>
<script type="text/javascript" src="${path }/js/page/product_detail.js"></script>
</html>