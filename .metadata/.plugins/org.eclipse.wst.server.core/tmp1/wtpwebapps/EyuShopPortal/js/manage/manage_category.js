var opIndex = 0;

$(function(){
	manage_CategoryCallback();
})

/**
 * 初始化函数
 */
function manage_CategoryCallback(){
	//监听提交
	  form.on('submit(category_form)', function(data){
		saveOrUpdateCategory(data.field);
	    return false;
	  });
	getCategoryList(1);
}

/**
 * 获取标签列表
 */
function getCategoryList(pageNum){
	$.ajax({
		url:remotePath+"/manage/category/list",
		type:"GET",
		success:function(result){
			if(result.code == 100){
				buildCategoryList(result.data);
			}else{
				$(".layui-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 构建标签列表
 * @param data
 */
function buildCategoryList(data){
	$("#category_table tbody").empty();
	$.each(data,function(index,item){
		var idTd=$("<td></td>").addClass("layui-table-cell").append(item.categoryId);
		var categoryNameTd=$("<td></td>").addClass("layui-table-cell").append(item.categoryName);
		var parentIdTd=$("<td></td>").addClass("layui-table-cell").append(item.parentId);
		var categoryStatusTd=$("<td></td>").addClass("layui-table-cell").append(item.categoryStatus);
		var createTimeTd=$("<td></td>").addClass("layui-table-cell").append(item.createTime);
		var updateTimeTd=$("<td></td>").addClass("layui-table-cell").append(item.updateTime);
		var btnEditCategory=$("<button></button>").addClass("layui-btn layui-btn-xs btn_editCategory").append("编辑");
		var btnDeleteCategory=$("<button></button>").addClass("layui-btn layui-btn-danger layui-btn-xs btn_deleteCategory").append("删除");
		var opTd=$("<td></td>").addClass("layui-table-cell").attr("categoryId",item.categoryId).append(btnEditCategory).append(btnDeleteCategory);
		
		var trEle=$("<tr></tr>").attr("index",index)
				.append(idTd)
				.append(categoryNameTd)
				.append(parentIdTd)
				.append(categoryStatusTd)
				.append(createTimeTd)
				.append(updateTimeTd)
				.append(opTd);
		$("#category_table tbody").append(trEle);
	})
}

/**
 * 点击了编辑
 */
$(document).on("click",".btn_editCategory",function(){
	$(".layui-body").empty();
	var categoryId=$(this).parent().attr("categoryid");
	$(".layui-body").load(path+"/jsp/manage/category/save_or_update_category.jsp",{},function(){
		getCategory(categoryId);
	})
})

function getCategory(categoryId){
	$.ajax({
		url:remotePath+"/manage/category/info",
		type:"GET",
		data:{"categoryId":categoryId},
		success:function(result){
			if(result.code ==100){
				initCategoryForm(result.data);
			}else{
				$(".layui-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
			
		}
	})
}

/**
 * 初始化表格
 * @param data
 */
function initCategoryForm(data){
	$.ajax({
		url:remotePath+"/manage/category/list",
		type:"GET",
		success:function(result){
			if(result.code == 100){
				initSelectOption(result.data);
				if(!isEmpty(data)){
					initFormData(data);
				}
			}else{
				$(".layui-body").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 给父节点的下拉框填充数据
 * @param data
 */
function initSelectOption(data){
	$("#parentId").empty();
	var rootOptionEle=$("<option></option>").prop("value","0").append("根节点");
	$("#parentId").append(rootOptionEle);
	$.each(data,function(index,item){
		var optionEle=$("<option></option>").prop("value",item.categoryId).append(item.categoryName);
		$("#parentId").append(optionEle);
	})
	$("input[name=categoryStatus]:eq(0)").prop("checked",true);
	form.render();
}

/**
 * 初始化表单数据
 * @param data
 */
function initFormData(data){
	$("#categoryId").val(data.categoryId);
	$("#categoryName").val(data.categoryName);
	$("#parentId").val(data.parentId);
	if(data.categoryStatus == 1){
		$("input[name=categoryStatus]:eq(0)").prop("checked",true);
	}else{
		$("input[name=categoryStatus]:eq(1)").prop("checked",true);
	}
	form.render();
}

/**
 * 点击了删除
 */
$(document).on("click",".btn_deleteCategory",function(){
	var categoryId=$(this).parent().attr("categoryId");
	opIndex=$(this).parents("tr").attr("index");
	console.log(opIndex);
	layer.confirm('确认删除吗?', {
		icon : 3,
		title : '删除标签'
	}, function(index) {
		deleteCategory(categoryId);
		layer.close(index);
	});
})

/**
 * 删除标签的逻辑
 * @param categoryId
 */
function deleteCategory(categoryId){
	$.ajax({
		url:remotePath+"/manage/category/delete",
		type:"POST",
		data:{"categoryId":categoryId},
		success:function(result){
			if(result.code == 100){
				$("#category_table tbody tr:eq("+opIndex+")").remove();
			}else{
				alert("删除失败");
			}
		}
	})
}

/**
 * 点击了新建标签
 */
$(document).on("click","#btn_createCategory",function(){
	$(".layui-body").empty();
	$(".layui-body").load(path+"/jsp/manage/category/save_or_update_category.jsp",{},function(){
		initCategoryForm(null);
	})
})

/**
 * 添加或者更新标签的逻辑
 * @param data
 */
function saveOrUpdateCategory(data){
	$.ajax({
		url:remotePath+"/manage/category/save_or_update",
		type:"POST",
		data:data,
		success:function(result){
			if(result.code == 100){
				$("#btn_returnToCategory").click();
			}else{
				//TODO	显示错误页面
				$("#category_form").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 点击了返回分类列表
 */
$(document).on("click","#btn_returnToCategory",function(){
	window.location.href=path+'/admin/cate';
})
