<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>

<style type="text/css">
</style>
</head>
<body >
<nav class="navbar navbar-inverse" style="margin:0;padding:0;border-radius:0;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">学生课程信息管理系统</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    

      <div class="navbar-header navbar-right col-md-2" style="position: relative;text-align:right;">
      	<div id="login_and_register" style="position:absolute;top:0;right:0;padding-top:8px;text-align: right;">
      	
      	</div>
      	<div id="headicon" style="position:absolute;top:0;right:0;">
	        <img class="img-circle" alt="" src="" style="display:inline-block; height:40px;width:40px;position: relative;bottom: 8px"/>
	        <span class="caret" style="position: relative;bottom: 8px"></span>
      	</div>
      </div>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

</body>
<script type="text/javascript">
$(function(){
	$("#login_and_register").hide();
	$("#headicon").hide();
	var currentUser="${currentUser}";
	if(currentUser==null||currentUser==''){
		console.log("当前没有登录用户");
		var btn_login=$("<button></button>").attr({type:'button',id:'btn_login'}).addClass("btn btn-sm btn-success").append("登录");
		var btn_register=$("<button></button>").attr({type:'button',id:'btn_register'}).addClass("btn btn-sm").append("注册");
		$("#login_and_register").append(btn_login).append("&nbsp;").append(btn_register);
		$("#login_and_register").show();
	}else{
		//console.log(currentUser);
	}
})

$("#headicon").hover(function(){
	$(this).addClass("btn-success");
},function(){
	$(this).removeClass("btn-success");
})

/**
 * 点击了登录按钮
 */
$(document).on("click","#btn_login",function(){
	$(location).prop("href","login.jsp");
})

/**
 * 点击了注册按钮
 */
$(document).on("click","#btn_register",function(){
	$(location).prop("href","register.jsp");
})
</script>

</html>