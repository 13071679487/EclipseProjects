<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<style type="text/css">
#menu .layui-nav{
	background-color:#fff;
}

#menu .layui-nav .layui-nav-item a:hover,#menu  .layui-nav .layui-this a {
	color: #fff;
}
#menu .layui-nav .layui-nav-bar,#menu .layui-nav .layui-nav-item{
	border-radius:0 25px 25px 0;
}
#menu .layui-nav a{
	color:rgba(80,80, 80, .7);
}
</style>
</head>
<body>
	<div class="layui-fluid">
		<!-- nav bar  -->
		<div class="layui-row">
			<jsp:include page="/jsp/common/header.jsp"></jsp:include>
		</div>
		
		<div class="layui-row layui-container" style="margin-top:100px;">
			<div class="layui-col-md2" id="menu" >
				<jsp:include page="/jsp/layout/personal_menu.jsp"></jsp:include>
			</div >		
			<div class="layui-col-md10 " id="content" style='padding-left:10px;'>
				<jsp:include page="/jsp/layout/personal_shipping.jsp"></jsp:include>
			</div>
		</div>
		
		<div class="layui-row">
			<jsp:include page="/jsp/common/footer.jsp"></jsp:include>
		</div>
		
	</div>
</body>
<script type="text/javascript"
	src="${path }/js/page/personal.js"></script>
	
<script type="text/javascript"
	src="/EyuShopPortal/js/layout/personal_shipping.js"></script>	
	
<script type="text/javascript"
	src="${path}/js/layout/personal_shipping_edit.js"></script>	
</html>