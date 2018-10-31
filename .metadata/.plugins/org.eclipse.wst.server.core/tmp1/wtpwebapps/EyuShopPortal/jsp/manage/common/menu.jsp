<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li id='manage-product' data-name="product" class="layui-nav-item">
          <a href="javascript:;" lay-tips="商品管理" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
                <cite>商品管理</cite>
              <span class="layui-nav-more"></span>
           </a>
          <dl class="layui-nav-child">
         	<dd id='manage-prod'>
          		<a class="href-item"  href="${path }/admin/prod">商品管理</a>
     	</dd>
     	<dd id='manage-reper'>
     		<a class="href-item"   href="${path }/admin/reper">仓库管理</a>
     	</dd>
     	<dd id='manage-cate'>
     		<a class="href-item"  href="${path }/admin/cate">商品标签管理</a>
     	</dd>
     </dl>
   </li>
   <li id='manage-order' data-name="manage-order" class="layui-nav-item">
   	<a  class="href-item" href="${path }/admin/order">
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