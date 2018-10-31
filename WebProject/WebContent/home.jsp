<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript"
	src="${path}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 引入js文件 -->
<script src="${path }/bootstrap3/js/bootstrap.min.js"></script>
<!-- 引入样式 -->
<link href="${path}/bootstrap3/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
html,body{
height:100%;
}
.left{
	background-color:gray;
	width:15%;
	height:100%;
	padding:0;
}
.right{
	padding:5px;
	width:85%;
	height:100%;
}
.list-group{
	margin-top:3px;
	background-color:gray;
	border:0;
	margin-bottom:0;
}
.list-group-item{
	background-color:gray;
	border-radius:0;
}

.panel-body{
	padding:0;
	height:100%;
}
.subTitle{
	font-color:#eee;
	size:20px;
	padding:0;
	margin:0;
	display:inline-block;
}
.subItem{
	font-color:#eee;
	padding:5px 0;
	size:14px;
	width:100%;
	border:0;
	border-radius:0;
}
.item{
	cursor:pointer;
}
.switch{
height:100%;
  cursor:pointer;
  background-color:gray;
	border:0;
	padding:5px 10px;
	border-radius:0;
}
.switch-right{
	float:right;
	margin-top:3px;
	background-color:background-color:gray;
	border:0;
	padding:0 10px;
	border-radius:#404040;
}
.speratorSubTitle{
	margin:1px 5px;
}
.glyphicon-remove{
	cursor:pointer;
}
</style>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body >
<div id="container" class="container-fluid" style="height:95%">
	<div class="row" style="height:100%">
		<div class="col-md-2 left">
			<ul class="list-group">
				<li class="list-group-item switch">
				  	<h5 class="subTitle">基本数据表维护</h5><span class="switch-right glyphicon"></span>
		        	<div  class="menuItem" >
		    	 		 <div class="panel-body">
		     		 		<ul class="list-group">
							  <li class="list-group-item subItem"><span url="student.jsp">学生表维护</span></li>
							  <li class="list-group-item subItem"><span url="major.jsp">选课表维护</span></li>
							  <li class="list-group-item subItem"><span url="lecture.jsp">课程表维护</span></li>
							  <li class="list-group-item subItem"><span url="college.jsp">学院表维护</span></li>
							  <li class="list-group-item subItem"><span url="teacher.jsp">教工表维护</span></li>
							  <li class="list-group-item subItem"><span url="teaching.jsp">授课表维护</span></li>
							</ul>
			     		 </div>
		     		 </div>
				</li>
				<hr class="speratorSubTitle"/>
				
				<li class="list-group-item switch">
					<h5 class="subTitle">简单查询</h5><span class="switch-right glyphicon"></span>
		        	<div  class="menuItem" >
		    	 		 <div class="panel-body">
		     		 		<ul class="list-group">
							  <li class="list-group-item subItem"><span url="studentinfo.jsp">学生情况查询</span></li>
							  <li class="list-group-item subItem"><span url="courseinfo.jsp">课程档案查询</span></li>
							  <li class="list-group-item subItem"><span url="majorinfo.jsp">选课与成绩查询</span></li>
							</ul>
			     		 </div>
		     		 </div>
				</li>
				<hr class="speratorSubTitle"/>
				
				<li class="list-group-item switch">
				  	<h5 class="subTitle">统计查询</h5><span class="switch-right glyphicon"></span>
		        	<div  class="menuItem" >
		    	 		 <div class="panel-body">
		     		 		<ul class="list-group">
							  <li class="list-group-item subItem"><span url="">学生情况统计</span></li>
							  <li class="list-group-item subItem"><span url="">教师任课查询</span></li>
							  <li class="list-group-item subItem"><span url="">学生成绩统计</span></li>
							</ul>
			     		 </div>
		     		 </div>
				</li>
				<hr class="speratorSubTitle"/>
				
				<li class="list-group-item switch">
				  	<h5  class="subTitle">报表</h5><span class="switch-right glyphicon"></span>
		        	<div  class="menuItem">
		    	 		 <div class="panel-body">
		     		 		<ul class="list-group">
							  <li class="list-group-item subItem"><span url="studentscoreform.jsp">个人成绩单</span></li>
							  <li class="list-group-item subItem"><span url="major.jsp">课程成绩单</span></li>
							  <li class="list-group-item subItem"><span url="studentinfoform.jsp">学生情况报表</span></li>
							  <li class="list-group-item subItem"><span url="addressinfoform.jsp">生源地人数</span></li>
							</ul>
			     		 </div>
		     		 </div>
				</li>
				<hr class="speratorSubTitle"/>
			</ul>
		</div>
		<div class="col-md-10 right">
			<ul class="nav nav-tabs" id="tabs">
			 <li role="presentation" class="active" url="readme.html"><a href="#" class="item">首页</a></li>
			</ul>
			<div class="embed-responsive embed-responsive-16by9" style="margin-top:10px;padding:0;">
			  <iframe class="embed-responsive-item" frameborder="0" scrolling="false"></iframe>
			</div>
		</div>
	</div>
</div><!-- 主的内容窗体 -->

</body>
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">

//全局的初始化函数
$(function(){
	initMenuAndStatus();
})
//初始化左边的列表信息
function initMenuAndStatus(){
	$(".switch-right").addClass("glyphicon-chevron-down");
	$(".switch").attr({"isOpen":0});
	$(".menuItem").hide();
	var bodyHeight=$("body").height();
	$(".panel-body").height(bodyHeight-250);
	$(".embed-responsive").height(bodyHeight-100);
}
//切换开关
$(".switch").on("click",function(){
	$(".menuItem").slideUp();
	$(".switch-right").removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
	var isOpen=$(this).attr("isOpen");
	if(isOpen=='1'){
		$(this).attr("isOpen",0);
		$(this).children(".menuItem").slideUp();
		$(this).children(".switch-right").removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
	}else{
		$(".switch").attr({"isOpen":0});
		$(this).attr("isOpen",1);
		$(this).children(".menuItem").slideDown();
		$(this).children(".switch-right").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
	}
})

$(".panel-body").on("click",function(event){
	event.stopPropagation();    //  阻止事件冒泡
})

$(".subItem").on("click",function(event){
	console.log("click the subItem ...")
	var url=$(this).children("span").attr("url");
	var tabName=$(this).children("span").text();
	console.log("click the item url:"+url+"--tabName:"+tabName);
	addTab(url,tabName);
	event.stopPropagation();    //  阻止事件冒泡
})
$(document).on("click",".item",function(){
	console.log("click the item button");
	var url=$(this).parent().attr("url");
	var tabName=$(this).text();
	console.log("click the item url:"+url+"--tabName:"+tabName);
	toggleTab(url,tabName);
})

function addTab(url,tabName){
	var isExsist=eleIsExsist(url);
	console.log("该节点是否存在："+isExsist);
	if(isExsist==-1){
		console.log("This ele is no exsist");
		var tabLength=$(".item").length;
		console.log("has item:"+tabLength);
		if(tabLength>8){
			$("#tabs").children("li:eq(1)").remove();
		}
		var deleteIcon=$('<span></span>').addClass('glyphicon glyphicon-remove');
		var tab=$("<li></li>").attr("role","presentation").addClass("active").attr("url",url);
		var btn_tab=$('<a></a>').addClass('item').append(tabName).append('&nbsp;').append(deleteIcon);
		tab.append(btn_tab);
		$('#tabs').append(tab);
		toggleTab(url,tabName);
	}else{
		console.log("This ele is exsist");
		toggleTab(url,tabName);
	}
}
function toggleTab(url) {
	$.each($("#tabs li"),function(index,item){
		$(item).removeClass('active');
		if($(item).attr("url")==url)
		{
			$(item).addClass('active');
		}
	});
	
	if(null==url){
		$('.embed-responsive-item').fadeOut('slow');
		return;
	}
	$('.embed-responsive-item').show();
	$('.embed-responsive-item').attr('src',url);
}

$(document).on("click",".glyphicon-remove",function(event){
	console.log("click the exit button");
	deleteTab(this);
	event.stopPropagation();    //  阻止事件冒泡
})

function deleteTab(ele){
	var ul=$(ele).parents('ul');
	$(ele).parent().parent().remove();
	var lastLi=$(ul).children('li').last();
	if(lastLi!=null){
		var url=$(lastLi).attr("url");
		toggleTab(url);
	}
}

function eleIsExsist(url){
	var result=-1;
	$.each($("#tabs li"),function(index,item){
		if($(item).attr("url")==url)
		{
			result=1;
		}
	});
	return result;
}


$(".subItem").on("mouseover",function(){
	$(this).children("span").prop({"style":"color:#eee;border-bottom:1px solid #eee"});
})
$(".subItem").on("mouseout",function(){
	$(this).children("span").prop({"style":"color:#333;border-bottom:0"});
})

</script>

</html>