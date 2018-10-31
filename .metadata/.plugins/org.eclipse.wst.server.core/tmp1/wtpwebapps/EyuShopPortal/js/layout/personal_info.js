$(function(){
	initUserInfo();
})

function personal_infoCallback(){
	$("#personal_menu").children("li").removeClass("layui-this");
	$('#personal_info').addClass("layui-this");
	initUserInfo();
}

/**
 * 初始化用户信息
 */
function initUserInfo(){
	$.ajax({
		url:remotePath+"/user/attr",
		type:"GET",
		success:function(result){
			if(!isEmpty(result.data)){
				$("#personal_headicon").prop("src",result.data.headIcon == null?"":result.data.headIcon+"?"+new Date());
				$("#personal_username").empty().append(result.data.username == null?"":result.data.username);
				$("#personal_account").empty().append(result.data.account == null?"":result.data.account);
				if(result.data.username=='m'){
					$("#personal_gender").addClass("layui-icon-male");
				}else{
					$("#personal_gender").addClass("layui-icon-female");
				}
				$("#personal_email").empty().append(result.data.email == null?"":result.data.email);
				$("#personal_address").empty().append(result.data.address == null?"未填写":result.data.address);
				element.render();
			}else{
				$("#content").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 点击了编辑个人资料
 */
$(document).on("click","#btn_updateModal",function(event){
	layer.open({
	      type: 2,
	      title: '修改资料',
	      maxmin: true,
	      shadeClose: true, //点击遮罩关闭层
	      area : ['520px' , '320px'],
	      content: 'jsp/layout/personal_info_edit.jsp'
	 });
	event.stopPropagation();
})


/**
 * 点击了更换头像
 */
$(document).on("click","#personal_headicon",function(event){
	layer.open({
	      type: 2,
	      title: '修改资料',
	      maxmin: true,
	      shadeClose: true, //点击遮罩关闭层
	      area : ['520px' , '320px'],
	      content: 'jsp/layout/personal_upload_headicon.jsp'
	 });
	event.stopPropagation();
})

