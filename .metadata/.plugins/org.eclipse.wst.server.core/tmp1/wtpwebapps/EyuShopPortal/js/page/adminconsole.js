var form;
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
});
layui.use('layer', function() {
	var layer = layui.layer;
});

layui.use('form', function(){
  form = layui.form;
});

$(document).on("click",".href-item",function(){
	$(".layui-body").empty();
	var url=$(this).attr("url");
	if(url==''||url==null){
		return;
	}
	$(".layui-body").load(url);
})

$(function(){
	toggleTab()
})

function toggleTab(){
	page = getIdFromUrl(window.location.href)
	if(page == 'order'){
		$('#manage-order').addClass('layui-this');
	}else if(page == 'prod'){
		$('#manage-product').addClass('layui-nav-itemed');
		$('#manage-prod').addClass('layui-this');
	}else if(page == 'cate'){
		$('#manage-product').addClass('layui-nav-itemed');
		$('#manage-cate').addClass('layui-this');
	}else if(page == 'reper'){
		$('#manage-product').addClass('layui-nav-itemed');
		$('#manage-reper').addClass('layui-this');
	}
}
