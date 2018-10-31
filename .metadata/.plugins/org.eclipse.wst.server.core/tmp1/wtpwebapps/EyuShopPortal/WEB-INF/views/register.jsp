<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body style="background:url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529661511339&di=0e69460f6682ce775d86ec67fd9fe458&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F64%2F13%2F62H58PICjNc_1024.jpg);">
	<div class="layui-fluid">
		<div class="layui-row">
			<jsp:include page="/jsp/common/header.jsp"></jsp:include>
		</div>
		
		<div class="layui-row">
			<div class="layui-col-md4 layui-col-md-offset4" style="margin-top:100px;">
				<div class="layui-carousel " id="register" style="background: none;">
				  <div carousel-item >
				  <!--   sign up  -->
				    <div class="layui-this" id="verifyPhoneTab" style="background: none;">
				    	<jsp:include page="/jsp/widget/verify_phone.jsp"></jsp:include>
				    </div>
				    <!--       set the password -->
				    <div id="setPasswordTab" style="background: none;">
				    	<jsp:include page="/jsp/widget/update_password.jsp"></jsp:include>
				    </div>
				    <!--  improve info  -->
				    <div id="improveInfoTab" style="background: none;">
				    	<jsp:include page="/jsp/widget/improve_info.jsp"></jsp:include>
				    </div>
				  </div>
				</div>
			</div>
			
		</div>
	</div>
</body>
<script src="${path }/js/page/register.js"></script>
<script type="text/javascript">
layui.use('carousel', function(){
  var carousel = layui.carousel;
  //建造实例
  carousel.render({
    elem: '#register'
    ,width: '100%'
    ,height:'360px'
    ,autoplay:false
    ,indicator:"none"
    ,arrow:"none"
  });
});
</script>
</html>