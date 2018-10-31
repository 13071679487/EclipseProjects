var element;
layui.use('element', function() {
	element = layui.element;

});
var carousel;
layui.use('carousel', function(){
  carousel = layui.carousel;
  //建造实例
  carousel.render({
    elem: '#advertisement'
    ,width: '100%' //设置容器宽度
    ,arrow: 'always' //始终显示箭头
    ,interval:"7000"
  });
});

/**
 * 初始化函数
 */
$(function(){
	getHeathList(1);
	getComputerAndPhoneList(1);
	getSkinBeautyList(1);
	getFoodList(1);
	getSportList(1);
	getApplianceList(1);
})

/**
 * 获取爱健康模块的商品
 * */
function getHeathList(pageNum){
	$.ajax({
		url:remotePath+"/product/list",
		type:"GET",
		data:{"cid":'13',"pn":pageNum},
		success:function(result){
			if(result.code == 100){
				buildHealthList(result.data);
			}else{
				$("#module_health .layui-card-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 获取爱搞机模块的商品
 * */
function getComputerAndPhoneList(pageNum){
	$.ajax({
		url:remotePath+"/product/list",
		type:"GET",
		data:{"cid":'8',"pn":pageNum},
		success:function(result){
			if(result.code == 100){
				buildTechnologyList(result.data);
			}else{
				$("#module_technology .layui-card-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}


/**
 * 获取爱美丽模块的商品
 * */
function getSkinBeautyList(pageNum){
	$.ajax({
		url:remotePath+"/product/list",
		type:"GET",
		data:{"cid":'7',"pn":pageNum},
		success:function(result){
			if(result.code == 100){
				buildSkinCareList(result.data);
			}else{
				$("#module_skincare .layui-card-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 获取爱吃模块的商品
 * */
function getFoodList(pageNum){
	$.ajax({
		url:remotePath+"/product/list",
		type:"GET",
		data:{"cid":'11',"pn":pageNum},
		success:function(result){
			if(result.code == 100){
				buildFoodList(result.data);
			}else{
				$("#module_food .layui-card-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 获取爱运动模块的商品
 * */
function getSportList(pageNum){
	$.ajax({
		url:remotePath+"/product/list",
		type:"GET",
		data:{"cid":'7',"pn":pageNum},
		success:function(result){
			if(result.code == 100){
				buildSportList(result.data);
			}else{
				$("#module_sport .layui-card-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 获取家居馆模块的商品
 * */
function getApplianceList(pageNum){
	$.ajax({
		url:remotePath+"/product/list",
		type:"GET",
		data:{"cid":'10',"pn":pageNum},
		success:function(result){
			if(result.code == 100){
				buildApplianceList(result.data);
			}else{
				$("#module_appliance .layui-card-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 构建健康商品列表
 */
function buildHealthList(data){
	$("#module_health .layui-card-body .layui-row").empty();
	$.each(data.list,function(index,item){
		var imgEle=$("<img></img>").prop({"style":"width:100px;height:120px;","src":item.imageHost+item.foreground});
		var productNameEle=$("<h4></h4>").append(item.productName);
		var priceEle=$("<span></span>").prop("style","color:#FF5722;font-size:16px;").append("<i class='layui-icon layui-icon-rmb' style='font-size: 12px; color: #FF5722;'></i>&nbsp;").append(item.price);
		var hrefEle=$("<a></a>").prop({"href":path+"/product?pid="+item.productId,"target":"_blank"}).append(imgEle).append(productNameEle).append(priceEle);
		
		var productDiv=$("<div></div>").addClass("layui-col-md6").prop("style","text-align: center;").append(hrefEle);
		$("#module_health .layui-card-body .layui-row").append(productDiv);
	})
	
	if(data.list.length<=0){
		$("#module_health .layui-card-body .layui-row").append("<h3 style='color:#c0c0c0;text-align: center'>列表为空</h3>");
	}
}

/**
 * 构建数码商品列表
 */
function buildTechnologyList(data){
	$("#module_technology .layui-card-body .layui-row").empty();
	$.each(data.list,function(index,item){
		var imgEle=$("<img></img>").prop({"style":"width:100px;height:120px;","src":item.imageHost+item.foreground});
		var productNameEle=$("<h4></h4>").append(item.productName);
		var priceEle=$("<span></span>").prop("style","color:#FF5722;font-size:16px;").append("<i class='layui-icon layui-icon-rmb' style='font-size: 12px; color: #FF5722;'></i>&nbsp;").append(item.price);
		var hrefEle=$("<a></a>").prop({"href":path+"/product?pid="+item.productId,"target":"_blank"}).append(imgEle).append(productNameEle).append(priceEle);
		
		var productDiv=$("<div></div>").addClass("layui-col-md6").prop("style","text-align: center;").append(hrefEle);
		$("#module_technology .layui-card-body .layui-row").append(productDiv);
	})
	
	if(data.list.length<=0){
		$("#module_technology .layui-card-body .layui-row").append("<h3 style='color:#c0c0c0;text-align: center'>列表为空</h3>");
	}
}

/**
 * 构建护肤商品列表
 */
function buildSkinCareList(data){
	$("#module_skincare .layui-card-body .layui-row").empty();
	$.each(data.list,function(index,item){
		var imgEle=$("<img></img>").prop({"style":"width:100px;height:120px;","src":item.imageHost+item.foreground});
		var productNameEle=$("<h4></h4>").append(item.productName);
		var priceEle=$("<span></span>").prop("style","color:#FF5722;font-size:16px;").append("<i class='layui-icon layui-icon-rmb' style='font-size: 12px; color: #FF5722;'></i>&nbsp;").append(item.price);
		var hrefEle=$("<a></a>").prop({"href":path+"/product?pid="+item.productId,"target":"_blank"}).append(imgEle).append(productNameEle).append(priceEle);
		
		var productDiv=$("<div></div>").addClass("layui-col-md6").prop("style","text-align: center;").append(hrefEle);
		$("#module_skincare .layui-card-body .layui-row").append(productDiv);
	})
	
	if(data.list.length<=0){
		$("#module_skincare .layui-card-body .layui-row").append("<h3 style='color:#c0c0c0;text-align: center'>列表为空</h3>");
	}
}

/**
 * 构建爱吃商品列表
 */
function buildFoodList(data){
	$("#module_food .layui-card-body .layui-row").empty();
	$.each(data.list,function(index,item){
		var imgEle=$("<img></img>").prop({"style":"width:100px;height:120px;","src":item.imageHost+item.foreground});
		var productNameEle=$("<h4></h4>").append(item.productName);
		var priceEle=$("<span></span>").prop("style","color:#FF5722;font-size:16px;").append("<i class='layui-icon layui-icon-rmb' style='font-size: 12px; color: #FF5722;'></i>&nbsp;").append(item.price);
		var hrefEle=$("<a></a>").prop({"href":path+"/product?pid="+item.productId,"target":"_blank"}).append(imgEle).append(productNameEle).append(priceEle);
		
		var productDiv=$("<div></div>").addClass("layui-col-md6").prop("style","text-align: center;").append(hrefEle);
		$("#module_food .layui-card-body .layui-row").append(productDiv);
	})
	
	if(data.list.length<=0){
		$("#module_food .layui-card-body .layui-row").append("<h3 style='color:#c0c0c0;text-align: center'>列表为空</h3>");
	}
}

/**
 * 构建运动商品列表
 */
function buildSportList(data){
	$("#module_sport .layui-card-body .layui-row").empty();
	$.each(data.list,function(index,item){
		var imgEle=$("<img></img>").prop({"style":"width:100px;height:120px;","src":item.imageHost+item.foreground});
		var productNameEle=$("<h4></h4>").append(item.productName);
		var priceEle=$("<span></span>").prop("style","color:#FF5722;font-size:16px;").append("<i class='layui-icon layui-icon-rmb' style='font-size: 12px; color: #FF5722;'></i>&nbsp;").append(item.price);
		var hrefEle=$("<a></a>").prop({"href":path+"/product?pid="+item.productId,"target":"_blank"}).append(imgEle).append(productNameEle).append(priceEle);
		
		var productDiv=$("<div></div>").addClass("layui-col-md4").prop("style","text-align: center;").append(hrefEle);
		$("#module_sport .layui-card-body .layui-row").append(productDiv);
	})
	
	if(data.list.length<=0){
		$("#module_sport .layui-card-body .layui-row").append("<h3 style='color:#c0c0c0;text-align: center'>列表为空</h3>");
	}
}

/**
 * 构建家居馆列表
 */
function buildApplianceList(data){
	$("#module_appliance .layui-card-body .layui-row").empty();
	$.each(data.list,function(index,item){
		var imgEle=$("<img></img>").prop({"style":"width:100px;height:120px;","src":item.imageHost+item.foreground});
		var productNameEle=$("<h4></h4>").append(item.productName);
		var priceEle=$("<span></span>").prop("style","color:#FF5722;font-size:16px;").append("<i class='layui-icon layui-icon-rmb' style='font-size: 12px; color: #FF5722;'></i>&nbsp;").append(item.price);
		var hrefEle=$("<a></a>").prop({"href":path+"/product?pid="+item.productId,"target":"_blank"}).append(imgEle).append(productNameEle).append(priceEle);
		
		var productDiv=$("<div></div>").addClass("layui-col-md2").prop("style","text-align: center;").append(hrefEle);
		$("#module_appliance .layui-card-body .layui-row").append(productDiv);
	})
	
	if(data.list.length<=0){
		$("#module_appliance .layui-card-body .layui-row").append("<h3 style='color:#c0c0c0;text-align: center'>列表为空</h3>");
	}
}
