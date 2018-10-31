$(function(){
	categorynavCallback();
})

/**
 * 初始化函数
 */
function categorynavCallback() {
	getCategoryList();
}

/**
 * 获取
 */
function getCategoryList() {
	$.ajax({
		url : remotePath + "/manage/category/root_list",
		type : "GET",
		success : function(result) {
			if (result.code == 100) {
				buildCategoryList(result.data);
			}
		}
	})
}

function buildCategoryList(data) {
	$("#category_nav").empty();
	$.each(data,function(index,item){
		var categoryName=$("<span></span>").append(item.categoryName);
		var href=$("<a></a>").prop("href","/EyuShopPortal/products?cid="+item.categoryId).append(categoryName);
		var li=$("<li></li>").addClass("layui-nav-item").append(href);
		if(!isEmpty(item.childCategoryList)){
			var dl=$("<dl></dl>").addClass("layui-nav-child");
			$.each(item.childCategoryList,function(i,child){
				var childhref=$("<a></a>").prop("href","/EyuShopPortal/products?cid="+child.categoryId).append(child.categoryName);
				var dd=$("<dd></dd>").append(childhref);
				dl.append(dd);
			})
			li.append(dl);
		}
		$("#category_nav").append(li);
	})
	element.render('nav');
}