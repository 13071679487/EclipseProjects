var element;

layui.use('element', function(){
  element = layui.element;
  
  /**
   * listen the event of tab
   */
  element.on('tab(register)', function(data){
	    console.log(data);
	    
  });
});

layui.use('form', function(){
	  var form = layui.form;
	  
	  form.on('submit(btn_toSetPassword)', function(data){
		  checkHasRegister(data.field);
		  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	  form.on('submit(btn_toImproveInfo)', function(data){
		  register(data.field);
		  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	  form.on('submit(btn_complete)', function(data){
		  improveUserInfo(data.field);
		  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	  
});
var layer;
layui.use('layer', function(){
	  layer = layui.layer;
	  
});  

var phone;
var userId;

/**
 * 检测是否已注册
 * @param phone
 */
function checkHasRegister(data){
	if(!isRightPhone($('#account').val())){
		layer.msg('手机号格式不正确')
		return;
	}
	$.ajax({
		url:remotePath+"/user/check_canregister",
		type:"GET",
		data:data,
		success:function(result){
			if(result.code == 100){
				phone=result.data;
				$("#update_pwd_account").val(result.data);
				$("#verifyPhoneTab").empty();
				$("#setPasswordTab").addClass("layui-show");
			}else{
				layer.msg(result.msg);
			}
		}
	})
}

/**
 * 注册
 * @param account
 * @param password
 */
function register(data){
	var password=$("#password").val().trim();
	var passwordrepeat=$("#passwordrepeat").val().trim();
	if(password != passwordrepeat){
		layer.msg("输入密码不一致");
		return;
	}
	if(!isRightPwd(password)){
		layer.msg('密码格式不正确')
		return;
	}
	$.ajax({
		url:remotePath+"/user/register",
		type:'POST',
		data:data,
		success:function(result){
			if(result.code == 100){
				userId=result.data.userId;
				$("#improve_info_userid").val(result.data.userId);
				$("#setPasswordTab").empty();
				$("#improveInfoTab").addClass("layui-show");
			}else{
				layer.msg("注册失败");
			}
		}
	})
}

/**
 * 完善用户信息
 */
function improveUserInfo(data){
	$.ajax({
		url:remotePath+"/user/improve_info",
		type:"POST",
		data:data,
		success:function(result){
			if(result.code == 100){
				window.location.href="/EyuShopPortal/login";
			}else{
				layer.msg("保存用户信息失败");
			}
		}
	})
}

/**
 * 点击了切换到设置密码
 */
$(document).on("click","#btn_toSetPassword",function(){
	console.log("click the btn_toSetPassword");
	var phoneValue=$("#account").val();
	var verifyCode = $("#verifycode").val();
	//checkHasRegister(phoneValue,verifyCode);
})

/**
 * 点击了切换到完善信息
 */
$(document).on("click","#btn_toImproveInfo",function(){
	
})

/**
 * 点击了保存用户信息
 */
$(document).on("click",'#btn_complete',function(){
	console.log("click the btn_complete");
	var username=$("input[name=username]").val().trim();
	var email=$("input[name=email]").val().trim();
	var sex=$("input[name=sex]").val();
	var data={"userId":userId,"username":username,"email":email,"sex":sex};
	//improveUserInfo(data);
})

$(document).on('click','#btn_code',function(){
	layer.msg('接口已关闭，请直接下一步');
	return false;
})


/**
 * 点击了切换到登录
 */
$("#btn_toLogin").on("click",function(){
	window.location.replace("login");
})