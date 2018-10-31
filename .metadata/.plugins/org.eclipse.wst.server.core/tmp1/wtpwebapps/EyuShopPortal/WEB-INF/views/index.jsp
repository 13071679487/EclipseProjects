<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五邑商城</title>
<style>
.layui-card .layui-card-body{
	border:1px solid #dddddd;
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

		<!-- advertisement  -->
		<div class="layui-row" style="margin-top: 5px;">
			<div class="layui-col-md10 layui-col-md-offset1">
				<div class="layui-carousel " id="advertisement">
					<div carousel-item>
						<div class="layui-this">
							<a > <img alt=""
								src="http://pic1.win4000.com/wallpaper/2/579963194649c.jpg">
							</a>
						</div>
						<div>
							<a > <img alt=""
								src="http://pic1.win4000.com/wallpaper/2/5799631fd48cd.jpg">
							</a>
						</div>
						<div>
							<a > <img alt=""
								src="http://uploads.5068.com/allimg/1711/151-1G12Q13936.jpg">
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- time limit seckill  -->
		<div class="layui-row" style="margin-top: 15px;">
			<jsp:include page="/jsp/modules/module_seckill.jsp"></jsp:include>
		</div>

		<!--  first sub module  -->
		<div class="layui-row" style="margin-top: 15px;">
			<div class="layui-col-md-10 layui-col-md-offset1" style="margin-right:8.3%;">
				<!-- health -->
				<div id="module_health" class="layui-col-md4 " style="padding: 5px;">
					<jsp:include page="/jsp/modules/module_health.jsp"></jsp:include>
				</div>
				<!-- computer and phone  -->
				<div id="module_technology" class="layui-col-md4" style="padding: 5px;">
					<jsp:include page="/jsp/modules/module_technology.jsp"></jsp:include>
				</div>
				<!-- skin beauty  -->
				<div id="module_skincare" class="layui-col-md4" style="padding: 5px;">
					<jsp:include page="/jsp/modules/module_skincare.jsp"></jsp:include>
				</div>
			</div>
		</div>
		
		<div class="layui-row" style="margin-top:15px;">
			<jsp:include page="/jsp/widget/topic_one_nav.jsp"></jsp:include>
		</div>
		
		<!-- second sub module -->
		<div class="layui-row" style="margin-top:15px;">
			<!-- food -->
			<div id="module_food" class="layui-col-md4 layui-col-md-offset1" style="padding: 5px;">
				<jsp:include page="/jsp/modules/module_food.jsp"></jsp:include>
			</div>
			<!-- sport -->
			<div id="module_sport" class="layui-col-md6 " style="padding: 5px;">
				<jsp:include page="/jsp/modules/module_sport.jsp"></jsp:include>
			</div>
		</div>
		
		<div class="layui-row" style="margin-top:15px;">
			<jsp:include page="/jsp/widget/topic_two_nav.jsp"></jsp:include>
		</div>
		
		
		<!-- third sub module -->
		<div class="layui-row" style="margin-top:15px;">
				<!-- appliance -->
			<div id="module_appliance" class="layui-col-md10 layui-col-md-offset1" style="padding: 5px;">
				<jsp:include page="/jsp/modules/module_appliance.jsp"></jsp:include>
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
<script type="text/javascript">
	
</script>
<script src="${path }/js/page/index.js"></script>
</html>