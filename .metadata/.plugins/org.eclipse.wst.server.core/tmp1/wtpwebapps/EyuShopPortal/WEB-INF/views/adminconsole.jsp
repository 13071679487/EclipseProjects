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
    <div class="layui-logo">五邑商城管理控制台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="${currentUser.headIcon }" class="layui-nav-img">
          ${currentUser.username }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="adminlogout" style='color:rgb(255,64,64,.6)'>注销</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li data-name="product" class="layui-nav-item">
          <a href="javascript:;" lay-tips="商品管理" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
                <cite>商品管理</cite>
              <span class="layui-nav-more"></span>
           </a>
          <dl class="layui-nav-child">
         	<dd>
          		<a class="href-item"  url="${path }/jsp/manage/manage_product.jsp">商品管理</a>
          	</dd>
          	<dd>
          		<a class="href-item"   url="${path }/jsp/manage/manage_product.jsp">仓库管理</a>
          	</dd>
          	<dd>
          		<a class="href-item"  url="${path }/jsp/manage/manage_category.jsp">商品标签管理</a>
          	</dd>
          </dl>
        </li>
        <li data-name="manage-order" class="layui-nav-item">
        	<a class="href-item" url="${path }/jsp/manage/manage_order.jsp">
        		<i class="layui-icon layui-icon-form"></i>
                <cite>订单管理</cite>
        	</a>
        </li>
        <li data-name="manage-promotion" class="layui-nav-item">
        	<a class="href-item" url="${path }/jsp/manage/manage_category.jsp">
        		<i class="layui-icon layui-icon-diamond"></i>
                <cite>促销管理</cite>
        	</a>
        </li>
        <li data-name="manage-feedback" class="layui-nav-item">
        	<a class="href-item" url="${path }/jsp/manage/manage_category.jsp">
        		<i class="layui-icon layui-icon-dialogue"></i>
                <cite>商家反馈</cite>
        	</a>
        </li>
        <li data-name="manage-message" class="layui-nav-item">
        	<a class="href-item" url="${path }/jsp/manage/manage_category.jsp">
        		<i class="layui-icon layui-icon-chat"></i>
                <cite>客户留言</cite>
             </a>
        </li>
        <li data-name="manage-statistics" class="layui-nav-item">
        	<a class="href-item" url="${path }/jsp/manage/manage_category.jsp">
        		<i class="layui-icon layui-icon-chart"></i>
                <cite>数据统计</cite>
             </a>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body" style="padding:15px;">
    <!-- 内容主体区域 -->
<!--      <div class="layadmin-tabsbody-item layui-show">
        </div> -->
          <iframe id='iframe-content'  frameborder="0" class="layadmin-iframe"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    联系作者：Rifu   13071679487
  </div>
</div>
<script src="${path }/layui/layui.all.js"></script>
<script type="text/javascript" src="${path }/js/page/adminconsole.js"></script>
<script type="text/javascript" src="/EyuShopPortal/js/manage/manage_product.js"></script>
<script type="text/javascript" src='/EyuShopPortal/js/manage/manage_order.js'></script>


</body>
</html>