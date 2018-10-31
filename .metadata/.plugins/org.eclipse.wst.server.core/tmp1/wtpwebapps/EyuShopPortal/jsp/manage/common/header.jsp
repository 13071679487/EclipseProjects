<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="layui-logo">五邑商城管理控制台</div>
<ul class="layui-nav layui-layout-right">
  <li class="layui-nav-item">
    <a id='headiconHref' href="javascript:;">
      <img id='headIcon' src="${currentUser.headIcon }" class="layui-nav-img">
      ${currentUser.username }
    </a>
   <dl class="layui-nav-child">
      <dd><a href="">基本资料</a></dd>
      <dd><a href="">安全设置</a></dd>
    </dl> 
  </li>
  <li class="layui-nav-item"><a href="${path }/adminlogout" style='color:rgb(255,64,64,.6)'>注销</a></li>
</ul>