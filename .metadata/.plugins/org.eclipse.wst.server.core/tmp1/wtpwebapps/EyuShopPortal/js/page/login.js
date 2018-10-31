layui.use('element', function() {
	var element = layui.element;

});
layui.use('form', function() {
	var form = layui.form;

	form.on('submit(login)', function(data) {
		preLogin(data.field);
		return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
});

layui.use('layer', function() {
	var layer = layui.layer;
});



$("#btn_toRegister").on("click", function() {
	window.location.replace("register");
})

/**
 * 刷新验证码
 */
$('#btn_refreshVerifycode').on('click',function(){
	$('#verify-code').prop('src',path+'/verifycode?t='+new Date())
	return false;
})

function preLogin(data) {
	var phone = $('#input_account').val();
	if(!isRightPhone(phone)){
		layer.msg('手机号格式不正确')
		return;
	}
	var hasRegister = checkHasRegister(phone)
	if(hasRegister){
		return;
	}
	checkVerifycode($('#input_verifycode').val(),data)
}

function checkHasRegister(account){
	var re=false;
	$.ajax({
		url:remotePath+"/user/check_canregister",
		type:"GET",
		data:{'account':account},
		success:function(result){
			if(result.code == 100){
				layer.msg('该账号未注册');
				 re = false;
			}else{
				re = true;
			}
		}
	})
	return re;
}

function checkVerifycode(verifycode,data){
	var re=false;
	$.ajax({
		url:path+"/checkverify",
		type:"GET",
		data:{'verifycode':verifycode},
		success:function(result){
			re=result;
			if(!re)
				layer.msg('验证码错误');
			else
				login(data)
		}
	})
	return re;
}

function login(data){
	$.ajax({
		url : remotePath+"/user/login",
		type:"POST",
		data : data,
		success : function(result) {
			if (result.code == 100) {
				setUserToSession(result.data,path+"/index");
			} else {
				layer.msg(result.msg);
			}
		},
		error:function(){
			layer.msg('无法连接');
		}
	})
}
