var form;
layui.use('form', function(){
  form = layui.form;
  
  //监听提交
  form.on('submit(product_form)', function(data){
	saveOrUpdateProduct(data.field);
    return false;
  });
});

$(function(){
	var pid = getUrlParam('pid');
	if(!isEmpty(pid)){
		getProduct(pid);
	}
	getCategoryList(null);
})

/**
 * 初始化summernote
 */
$('#summernote').summernote({
	lang: 'zh-CN',
    tabsize: 2,
    disableDragAndDrop:true,
    minHeight:350,
    callbacks:{
		onImageUpload:function(files, editor, $editable){
			uploadImage(files, editor, $editable);
		}
	}
});

/**
 * 上传图片
 */
function uploadImage(files, editor, $editable){
	var formData = new FormData();  
    formData.append("file", files[0]);  
    $.ajax({  
        data : formData,  
        type : "POST",  
        url : remotePath+"/manage/product/upload", //图片上传出来的url，返回的是图片上传后的路径，http格式  
        cache : false,  
        contentType : false,  
        processData : false,  
        success: function(result) {//data是返回的hash,key之类的值，key是定义的文件名  
        	if(result.code==100){
        		$.each(result.data,function(index,item){
        			console.log(item);
        			$('#summernote').summernote('insertImage', remoteImgServer+item);
        		})
        	}else{
        		alert("Upload fail....");
        	}
        },  
        error:function(){  
            alert("Upload fail....");  
        }  
    });  
}


/**
 * 增加或者修改商品
 * @param data
 */
function saveOrUpdateProduct(data){
	$.ajax({
		url:remotePath+"/manage/product/save_or_update",
		type:"POST",
		data:data,
		success:function(result){
			if(result.code == 100){
				$("#product_form").empty();
				alert("发布成功");
			}else{
				//TODO	显示错误页面
				alert("发布失败");
			}
		}
	})
}

/**
 * 点击了保存按钮
 */
$("#btn_submitProduct").on("click",function(){
	var content=$("#summernote").summernote('code');
	$("#productDetail").val(content);
})


/**
 * 点击了添加商品图片
 */
$(document).on("click",".product-image-add",function(){
	var length=$(".product-image-del").length;
	if(length > 6){
		alert("最多上传6张图片");
	}else{
		$("#product_image_file").click();
	}
})

/**
 * 监听选择完图片
 */
$(document).on("change","#product_image_file",function(){
	if(this.files&&this.files[0]){
		uploadProductSubImage(this.files);
		var reader =new FileReader();
		reader.onload=function(evt){
			var deleteEle=$("<a></a>").addClass("product-image-del").append($("<i></i>").addClass("layui-icon layui-icon-close"));
			var imgEle=$("<img></img>").addClass("product-image").prop({"src":evt.target.result});
			var Div=$("<div></div>").addClass("product-image-item").append(deleteEle).append(imgEle);
			var liEle=$("<li></li>").append(Div);
			var length=$(".product-image-del").length==0?1:$(".product-image-del").length;
			$("#product-add").before(liEle);
		}
		reader.readAsDataURL(this.files[0]);
	}
})

/**
 * 上传图片
 */
function uploadProductSubImage(files){
	var formData = new FormData();  
    formData.append("file", files[0]);  
    $.ajax({  
        data : formData,  
        type : "POST",  
        url : remotePath+"/manage/product/upload", //图片上传出来的url，返回的是图片上传后的路径，http格式  
        cache : false,  
        contentType : false,  
        processData : false,  
        success: function(result) {//data是返回的hash,key之类的值，key是定义的文件名  
        	if(result.code==100){
        		var subimages=$("#subimages").val().trim();
        		$.each(result.data,function(index,item){
        			if(isEmpty(subimages)){
        				subimages=item;
        			}else{
        				subimages=subimages+","+item;
        			}
        		})
        		$("#subimages").val(subimages);
        	}else{
        		alert("Upload fail....");
        	}
        },  
        error:function(){  
            alert("Upload fail....");  
        }  
    });  
}



/**
 * 点击了返回上一层
 */
$(document).on("click","#btn_return",function(){
//	$(".layui-body").empty().append(tempDiv);

})

/**
 * 根据商品ID获取商品详情
 * @param productId
 */
function getProduct(productId){
	$.ajax({
		url:remotePath+"/product/info",
		type:"GET",
		data:{"pid":productId},
		success:function(result){
			if(result.code == 100){
				initProductForm(result.data);
			}else{
//				$(".layui-body").empty().append(tempDiv);
				$('#product_form').empty().load(path+'/jsp/widget/error404.jsp');
			}
		}
	})
}

/**
 * 根据获取到的数据进行表单填充
 */
function initProductForm(data){
	$("#productId").val(data.productId);
	$("#productName").val(data.productName);
	$("#subtitle").val(data.subtitle);
	$("#price").val(data.price);
	$("#stock").val(data.stock);
	
	getCategoryList(data.categoryId);
	
	var i=data.productStatus==0?1:0;
	$("input[name=productStatus]:eq("+i+")").prop("checked",true);
	$.each(data.subimages,function(index,item){
		var deleteEle=$("<a></a>").addClass("product-image-del").append($("<i></i>").addClass("layui-icon layui-icon-close"));
		var imgEle=$("<img></img>").addClass("product-image").prop({"src":data.imageHost+item});
		var Div=$("<div></div>").addClass("product-image-item").append(deleteEle).append(imgEle);
		var liEle=$("<li></li>").append(Div);
		var length=$(".product-image-del").length==0?1:$(".product-image-del").length;
		$("#product-add").before(liEle);
	})
	
	$("#summernote").summernote('code',data.detail);
}

function getCategoryList(categoryId){
	$.ajax({
		url:remotePath+"/manage/category/list",
		type:"GET",
		success:function(result){
			if(result.code == 100){
				initSelectOption(categoryId,result.data);
			}
		}
	})
}
/**
 * 填充分类标签的下拉填充框
 * @param data
 */
function initSelectOption(categoryId,data){
	$("#categoryId").empty();
	$.each(data,function(index,item){
		var optionEle=$("<option></option>").prop("value",item.categoryId).append(item.categoryName);
		$("#categoryId").append(optionEle);
	})
	if(!isEmpty(categoryId))
		$("#categoryId").val(categoryId);
	form.render();
}

