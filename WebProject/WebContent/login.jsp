<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>

<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript"
	src="${path}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 引入js文件 -->
<script
	src="${path }/bootstrap3/js/bootstrap.min.js"></script>
<!-- 引入样式 -->
<link href="${path}/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
	
</head>
<%
	String sessionId=session.getId();
%>
<jsp:include page="header.jsp"></jsp:include>
<body style="background:url('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522742884826&di=80267ab282f484781750e9c7fdc4479d&imgtype=0&src=http%3A%2F%2Fpptdown.pptbz.com%2Fpptbeijing%2F%25E7%25B2%25BE%25E9%2580%2589%25E7%25BA%25BF%25E6%259D%25A1%25E5%2588%259B%25E6%2584%258F%25E7%25AE%2580%25E7%25BA%25A6PPT%25E8%2583%258C%25E6%2599%25AF%25E5%259B%25BE%25E7%2589%2587.jpg') no-repeat">
	<div class="container-fluid">
		<div class="row" style="margin-top: 10%">
			<div class="jumbotron col-md-4 col-md-offset-4" >
			 <form class="form-horizontal" action="#" method="POST">
				<!-- 账号  -->
	          <div class="form-group">
			    <label class="col-sm-3 col-sm-offset-1 control-label">账号</label>
			    <div class="col-sm-6">
			      <input type="text" name="account"class="form-control" id="account" placeHolder="Please input account"/>
			      <span class="help-block"></span>
			    </div>
			  </div>
				
			  	<!--Password  -->
			  <div class="form-group">
			    <label class="col-sm-3 col-sm-offset-1 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" name="password"class="form-control" id="password" placeHolder="Please input password"/>
			      <span class="help-block"></span>
			    </div>
			  </div>
				  
				   	<!-- 验证码  -->
          <div class="form-group">
		    <label class="col-sm-3 col-sm-offset-1 control-label">验证码</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" id="verifycode" placeHolder="Please input account" style="width:70px;display: inline-block;"/>
		      	<img id="verifyCode"  src="${path }/verifycode" style="border-radius:5px;border:1px solid gray" style="text-align:center; display: inline-block;margin-top:0px;"/>
		      	<button type="button" id="btn_refreshVC" class="btn"><span class="glyphicon glyphicon-repeat"></span></button>
		      	<button type="button" id="btn_autoScan" class="btn btn-xs btn-success">自动检测</button>
		      <span class="help-block"></span>
		    </div>
		  </div>
				
			<div style="text-align: center;">
				<span class="help-block"></span>
				<button type="button" id="btn_submit" class="btn btn-primary">登录</button>
				<br><br>
				<a href="register.jsp">没有账号，先去注册一个&nbsp;></a>				
			</div>
			 </form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
var verify;

$("#verifyCode").load(function(){
	console.log("图片加载完成");
	getSessionAttr("verifyCode");
	var time=new Date();
	console.log("获取验证码的时间是："+time);
})

/**
 * 更换验证码的函数实现
 */
function getVerifyCode(){
	var time=new Date().getTime();
	$("#verifyCode").prop("src","${path }/verifycode?time="+time);
	getSessionAttr("verifyCode");
	var time=new Date();
	console.log("获取验证码的时间是："+time);
}
/**
 * 通过ajax请求实时获取session里面的属性
 */
function getSessionAttr(attr){
	$.ajax({
		url:"${path}/sessionAttr",
		type:"get",
		data:{"attr":attr},
		success:function(data){
			console.log("getSessionAttr("+attr+"):"+data);
			verify=data.toLowerCase();
		}
	})
}


/**
 * 点击验证码进行切换
 */
$("#verifyCode").on("click",function(){
	refreshVC();
})

$("#btn_refreshVC").on("click",function(){
	refreshVC();
})

/**
 * 点击了登录按钮
 */
 
$("#btn_submit").on("click",function(){
	console.log("click the login...");
	var accountVal=$("#account").val();
	var passwordVal=$("#password").val();
	var verifycodeVal=$("#verifycode").val().toLowerCase();
	console.log("accout:"+accountVal+"--password:"+passwordVal+"---verifyCode:"+verifycodeVal+"---verify:"+verify);
	if(verify!=null&&verify!=''){
		$(this).parent().children("span").text("");
		if(verifycodeVal==verify){
			$.ajax({
				url:"${path }/user/login",
				type:"GET",
				data:{account:accountVal,password:passwordVal},
				success:function(result){
					location.href ="${path }/"+result.extend.href;
				},
				error:function(){
					console.log("login fail..");
				}
			})
		}else{
			console.log("验证码不正确");
			$("#verifycode").parent().addClass("has-error");
			$("#verifycode").parents(".input-group").children("span").text("验证码错误");
		}	
	}else{
		$(this).parent().children("span").text("请不要重复提交");
	}
})

/**
 * 动态监测验证码是否填写正确并作出提示
 */
$("#verifycode").change(function(){
	console.log("verifyCode has change..")
	$("#verifycode").parent().removeClass("has-success has-error");
	var verifycodeVal=$("#verifycode").val().toLowerCase();
	if(verify==verifycodeVal){
		$("#verifycode").parent().addClass("has-success");
		$("#verifycode").parent().children("span").text("");
	}else{
		$("#verifycode").parent().addClass("has-error");
		$("#verifycode").parent().children("span").text("验证码错误");
	}
})

/**
 * 点击了自动检测按钮，自动填写验证码
 */
 $("#btn_autoScan").on("click",function(){
	 $("#verifycode").val(verify);
 })

/**
 * 刷新验证码
 */
function refreshVC(){
	console.log("refresh the verifyCode...")
	getVerifyCode();
	$("#verifycode").change();
}
</script>
</html>