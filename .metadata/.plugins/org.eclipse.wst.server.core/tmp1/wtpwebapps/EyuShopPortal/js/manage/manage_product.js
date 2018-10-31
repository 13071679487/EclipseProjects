/**
 * 获取商品列表
 * @param key
 * @param cid
 * @param pageNum
 */
function getProductList(key,cid,pageNum){
	currentPagenum=pageNum;
	$.ajax({
		url:remotePath+"/manage/product/list",
		type:"GET",
		data:{"key":key,"cid":cid,"pn":pageNum,"size":"8"},
		success:function(result){
			if(result.code == 100){
				buildProductList(result.data);
				buildPageNav(result.data);
			}else{
				$(".layui-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 构建商品列表
 * @param data
 */
function buildProductList(data){
	$("#product_table tbody").empty();
	$.each(data.list,function(index,item){
		var idTd=$("<td></td>").addClass("layui-table-cell").append(item.productId);
		var productImage=$("<img></img>").prop("src",item.imageHost+item.foreground);
		var productImageTd=$("<td></td>").addClass("layui-table-cell").append(productImage);
		var productNameTd=$("<td></td>").addClass("layui-table-cell").append(item.productName);
		var categoryIdTd=$("<td></td>").addClass("layui-table-cell").append(item.categoryId);
		var priceTd=$("<td></td>").addClass("layui-table-cell").append(item.price);
		var stockTd=$("<td></td>").addClass("layui-table-cell").append(item.stock);
		var productStatusTd=$("<td></td>").addClass("layui-table-cell");
		var toggleProductStatus;
		if(item.productStatus==1){
			toggleProductStatus=$("<button></button>").addClass("layui-btn layui-btn-xs btn_outSale").append("下架");
			var productStatus="<span class='layui-badge layui-bg-green'>在售</span>";
			productStatusTd.append(productStatus);
		}else{
			toggleProductStatus=$("<button></button>").addClass("layui-btn layui-btn-xs btn_onSale").append("上架");
			var productStatus="<span class='layui-badge layui-bg-gray'>已下架</span>";
			productStatusTd.append(productStatus);
		}
		var btnEditCategory=$("<button></button>").addClass("layui-btn layui-btn-xs btn_editProduct").append("编辑");
		var btnDeleteCategory=$("<button></button>").addClass("layui-btn layui-btn-danger layui-btn-xs btn_deleteProduct").append("删除");
		var opTd=$("<td></td>").addClass("layui-table-cell").attr({"productId":item.productId,"productStatus":item.productStatus}).append(toggleProductStatus).append(btnEditCategory).append(btnDeleteCategory);
		
		var trEle=$("<tr></tr>").attr("index",index)
				.append(idTd)
				.append(productImageTd)
				.append(productNameTd)
				.append(categoryIdTd)
				.append(priceTd)
				.append(stockTd)
				.append(productStatusTd)
				.append(opTd);
		$("#product_table tbody").append(trEle);
	})
}

/**
 * 构建分页导航条
 * @param data
 */
function buildPageNav(data){
	if(data.hasPreviousPage){
		$("#btn_prePage").removeClass("layui-btn-disabled");
		$("#btn_prePage").click(function(){
			getProductList(null,0,data.pageNum-1);
		})
	}else{
		$("#btn_prePage").addClass("layui-btn-disabled");
	}
	pages=data.pages;
	if(data.hasNextPage){
		$("#btn_nextPage").removeClass("layui-btn-disabled");
		$("#btn_nextPage").click(function(){
			getProductList(null,0,data.pageNum+1);
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
			getProductList(null,0,item);
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
		getProductList(null,0,targetPage);
	}
})

/**
 * 点击了编辑商品
 */
$(document).on("click",".btn_editProduct",function(){
	tempDiv=$(".layui-body").html();
//	$(".layui-body").empty();
	var productId=$(this).parent().attr("productId");
	window.open(path+"/saveproduct?pid="+productId,'_blank')
//	$(".layui-body").load(path+"/jsp/manage/product/save_or_update_product.jsp",{},function(){
//		getProduct(productId);
//	})
})

/**
 * 点击了删除商品
 */
$(document).on("click",".btn_deleteProduct",function(){
	var productId=$(this).parent().attr("productId");
	if(!isEmpty(productId)){
		deleteProduct(productId);
	}
})

/**
 * 根据商品ID删除商品的逻辑
 * @param productId
 */
function deleteProduct(productId){
	$.ajax({
		url:remotePath+"/manage/product/delete",
		type:"POST",
		data:{"pid":productId},
		success:function(result){
			if(result.code == 100){
				getProductList(null,0,currentPagenum);
				layer.msg("删除成功")
			}else{
				layer.msg(result.msg);
			}
		}
	})
}

/**
 * 点击了下架商品
 */
$(document).on("click",".btn_outSale",function(){
	var productId=$(this).parent().attr("productId");
	var status=$(this).parent().attr("productStatus")==0? 1:0;
	if(!isEmpty(productId)){
		outSale(productId,status);
	}
})

/**
 * 点击了上架架商品
 */
$(document).on("click",".btn_onSale",function(){
	var productId=$(this).parent().attr("productId");
	var status=$(this).parent().attr("productStatus")==0? 1:0;
	if(!isEmpty(productId)){
		outSale(productId,status);
	}
})

/**
 * 根据商品ID下架商品
 * @param productId
 */
function outSale(productId,status){
	$.ajax({
		url:remotePath+"/manage/product/set_product_sale_status",
		type:"POST",
		data:{"productId":productId,"status":status},
		success:function(result){
			if(result.code == 100){
				getProductList(null,0,currentPagenum);
				layer.msg("成功");
			}else{
				layer.msg("更新商品状态失败");
			}
		}
	})
}

/**
 * 点击了新建商品
 */
$(document).on("click","#btn_createProduct",function(){
	tempDiv=$(".layui-body").html();
//	$(".layui-body").empty();
//	$(".layui-body").load(path+"/jsp/manage/product/save_or_update_product.jsp",{},function(){
//	})
	window.open(path+"/saveproduct",'_blank')
})


