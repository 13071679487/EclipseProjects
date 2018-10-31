layui.use('element', function() {
	var element = layui.element;

});
layui.use('form', function() {
	var form = layui.form;

	form.on('submit(*)', function(data) {
		login(data.field);
		return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
});

layui.use('layer', function() {
	var layer = layui.layer;
});

$("#btn_login").on("click", function(event) {
	var account = $("#input_account").val().trim();
	var password = $("#input_password").val().trim();
})

$("#btn_toRegister").on("click", function() {
	window.location.replace("register");
})

$('#input_account').bind('keydown',function(event){
	if(event.keycode == 13){
		$("#btn_toRegister").click()
	}
})
$('#input_password').bind('keydown',function(event){
	if(event.keycode == 13){
		$("#btn_toRegister").click()
	}
})

function login(data) {
	$.ajax({
		url : remotePath+"/user/login",
		type:"POST",
		data : data,
		success : function(result) {
			if (result.code == 100) {
				setUserToSession(result.data,path+"/admin");
			} else {
				layer.msg(result.msg);
			}
		}
	})
}

