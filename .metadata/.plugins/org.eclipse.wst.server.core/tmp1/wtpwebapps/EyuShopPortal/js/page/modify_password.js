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
	  
});
$(function(){
	$("#btn_toImproveInfo").empty().append("确认修改");
})

/**
 * 点击了切换到设置密码
 */
$(document).on("click","#btn_toSetPassword",function(){
	console.log("click the btn_toSetPassword");
	$("#verifyPhoneTab").empty();
	$("#setPasswordTab").addClass("layui-show");
})

/**
 * 点击了切换到完善信息
 */
$(document).on("click","#btn_toImproveInfo",function(){
	console.log("click the btn_toImproveInfo");
	
})





/**
 * 点击了切换到登录
 */
$("#btn_toLogin").on("click",function(){
	window.location.replace("login");
})