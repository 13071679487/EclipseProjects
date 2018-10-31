var element;
layui.use('element', function() {
	element = layui.element;

});

$(function(){
	init();
})

/**
 * 初始化函数
 */
function init(){
	getProductList(1);
}
var lowPrice = 0;
var highPrice =99999;
var orderby;
var orderbyPrice=0;


/**
 * 获取商品列表
 * @param pageNum
 */
function getProductList(pageNum){
	var key=getUrlParam("key");
	var cid=getUrlParam("cid");
	$.ajax({
		url:remotePath+"/product/list",
		type:"GET",
		data:{"key":key,"cid":cid,"pn":pageNum,'size':40,"orderby":orderby,"low":lowPrice,"high":highPrice},
		success:function(result){
			if(result.code == 100){
				buildProductList(result.data);
				buildPageNav(result.data);
			}else{
				$("#product-list ul").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 构建商品列表
 * @param data
 */
function buildProductList(data){
	$("#product-list ul").empty();
	$.each(data.list,function(index,item){
		var imgEle=$("<img></img>").prop("src",item.imageHost+item.foreground);
		var productNameEle=$("<h5></h5>").append(item.productName);
		var priceEle=$("<span></span>").prop("style","color:#FF5722;font-size:16px;")
				.append("<i class='layui-icon layui-icon-rmb' style='font-size: 12px; color: #FF5722;'></i>&nbsp;")
				.append(item.price);
		var hrefEle=$("<a></a>").prop("href",path+"/product?pid="+item.productId).append(imgEle).append(productNameEle).append(priceEle);
		
		var liEle=$("<li></li>").addClass("product-item").append(hrefEle);
		$("#product-list ul").append(liEle);
	})
	var length=$("#product-list .product-item").length;
	if( length == 0){
		$("#product-list ul").append("<li><div class='layui-col-md12' ><h1 style='margin:50px 0;text-align:center;color:#aaa'>空空如也</h1></div></li>")
	}
}


/**
 * 构建分页导航条
 * @param data
 */
function buildPageNav(data){
	if(data.hasPreviousPage){
		$("#btn_prePage").removeClass("layui-btn-disabled");
		$("#btn_prePage").click(function(){
			getProductList(data.pageNum-1);
		})
	}else{
		$("#btn_prePage").addClass("layui-btn-disabled");
	}
	pages=data.pages;
	if(data.hasNextPage){
		$("#btn_nextPage").removeClass("layui-btn-disabled");
		$("#btn_nextPage").click(function(){
			getProductList(data.pageNum+1);
		})
	}else{
		$("#btn_nextPage").addClass("layui-btn-disabled");
	}
	
	$("#navigation_nums").empty();
	var ulEle=$("<ul></ul>");
	$.each(data.navigatepageNums,function(index,item){
		var btnEle=$("<button></button>").addClass("layui-btn layui-btn-primary layui-btn-sm").append(item);
		if(data.pageNum == index +1){
			btnEle.addClass("layui-btn-disabled");
		}
		btnEle.click(function(){
			getProductList(item);
		})
		var liEle=$("<li></li>").append(btnEle);
		ulEle.append(liEle);
	})
	$("#navigation_nums").append(ulEle);
	
	$("#pages").empty().append(data.pages);
	
}

/**
 * 点击了跳转页数
 */
$(document).on("click","#btn_skipPage",function(){
	var targetPage=parseInt($("#input_skipPage").val());
	if(!isEmpty(targetPage)&&targetPage <= pages){
		getProductList(targetPage)
	}
})

$("#btn_screen").on("click",function(){
	$("#screen_panel").slideToggle();
})

/**
 * 点击进行价格区间筛选
 */
$("#btn_ensureScreen").on("click",function(){
	var numReg=/^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$/;
	var low=$("#lowPrice").val().trim();
	var high=$("#highPrice").val().trim();
	if(numReg.test(low) && numReg.test(high)){
		if(parseInt(high) < parseInt(low)){
			layer.msg("价格区间输入错误");
			return;
		}
		lowPrice = low;
		highPrice =high;
		getProductList(1);
		$("#screen_panel").slideUp();
	}else{
		layer.msg("输入的价格格式有误");
	}
})

/**
 * 选择了综合排序
 */
$("#sort_default").on("click",function(){
	$("#sort_price").prop("style","color:#c0c0c0;");
	$(this).prop("style","color:#fff;");
	orderby="";
	orderbyPrice=0;
	getProductList(1);
})

/**
 * 选择了价格排序
 */
$("#sort_price").on("click",function(){
	$("#sort_default").prop("style","color:#c0c0c0;");
	$(this).prop("style","color:#fff;");
	if(orderbyPrice%2 == 0){
		orderby="price_desc";
	}else{
		orderby="price_asc";
	}
	getProductList(1);
	orderbyPrice++;
})