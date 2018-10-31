$(function(){
	personal_collectionCallback()
})

/**
 * 初始化函数
 */
function personal_collectionCallback(){
	$("#personal_menu").children("li").removeClass("layui-this");
	$('#personal_collection').addClass("layui-this");
}