<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>五邑商城管理控制台</title>

<style type="text/css">
.layui-nav-tree li{
	point:cursor;
}
</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <%@ include file="/jsp/manage/common/header.jsp"%>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <%@ include file="/jsp/manage/common/menu.jsp"%>
    </div>
  </div>
  
  <div class="layui-body" style="padding:15px;">
    <!-- 内容主体区域 -->
     <jsp:include page="/jsp/manage/manage_order.jsp"></jsp:include>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    联系作者：Rifu   13071679487
  </div>
</div>
<script src="${path }/layui/layui.all.js"></script>
<script type="text/javascript" src="${path }/js/page/adminconsole.js"></script>
 <!-- <script type="text/javascript" src="/EyuShopPortal/js/manage/manage_product.js"></script> -->
<script type="text/javascript" src='/EyuShopPortal/js/manage/manage_order.js'></script>


</body>
</html>