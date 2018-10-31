<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path=request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<html>
<head>
<title>商品信息</title>
<link rel="icon" href="https://getbootstrap.com/favicon.ico">

<script src="${path }/layui/layui.js"></script>
<script src="${path }/js/common.js"></script>
<link href="${path}/layui/css/layui.css" rel="stylesheet">
<link href="${path}/css/common.css" rel="stylesheet">
<script src="${path }/richtext/jquery-3.2.1.js"></script> 
<!-- include summernote css/js-->
<link href="${path }/richtext/summernote-lite.css" rel="stylesheet">
<script src="${path }/richtext/summernote-lite.js"></script>
<script src="${path }/richtext/lang/summernote-zh-CN.js"></script>
<style type="text/css">

	#category_form .layui-select-title i{
	 right:120px;
	}
	
	#product_form .layui-form-item label{
		color:rgba(80,80,80,.7);
	}
	#product_subimages{
		list-style:none;
	}
	#product_subimages li{
		float:left;
		margin-left:10px;
		margin-top:5px;
	}
	
	.product-image-item{
		position:relative;
		border:2px dotted rgba(200,200,200,.8);
		padding:2px;
		width:90px;
		height:120px;
	}
	
	.product-image{
		width:90px;
		height:120px;
	}
	
	.product-image-del{
		position:absolute;
		top:0;
		right:0;
		border-radius:50%;
		width:20px;
		height:20px;
		background-color:rgba(200,200,200,.8);
		color:#f00;
		text-align: center;
	}
	.product-image-del i{
		font-size:18px;
	}
	.product-image-add{
		position:absolute;
		top:40%;
		left:36%;
		text-align: center;
		color:#009688;
	}
	.product-image-add i{
		font-size:30px;
	}
	

	
	
</style>
</head>
<body class='layui-container'>

					<div class="layui-row" style="margin-top:15px;margin-left:20px;">
					
						<div class=" layui-col-md4">
							<button id="btn_return" class="layui-btn layui-btn-sm" style="width:35px;height:35px;border-radius:50%;">
								<i class="layui-icon layui-icon-return" style=""></i>
							</button>
							<span style="font-size:15px;color:#444;">返回上一层</span>
						</div>
						
						<div class=" layui-col-md2 layui-col-md-offset6">
							<button class="layui-btn">预览</button>
						</div>
					</div>

					<div class="layui-row" style="margin-top:25px;">
						<div class="layui-col-md12">
							
						<form id="product_form" class="layui-form" style="margin-top:25px;">
			    			<div class="layui-form-item" style="display:none;">
					    		<div class="layui-input-block">
							      <input  type="text" id="productId" name="productId" >
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" >商品名字：</label>
					    		<div class="layui-input-block">
							       <input  type="text" id="productName" name="productName" required  lay-verify="required" placeholder="请输入商品名字" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" >子标题：</label>
					    		<div class="layui-input-block">
							       <input  type="text" id="subtitle" name="subtitle" required  lay-verify="required" placeholder="请输入商品子标题" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" >商品单价：</label>
					    		<div class="layui-input-block">
							       <input  type="text" id="price" name="price" required  lay-verify="required" placeholder="请输入商品单价(单位元)" autocomplete="off" class="layui-input input-radius-20px"  style="width:128px;">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" >商品库存：</label>
					    		<div class="layui-input-block">
							       <input  type="text" id="stock"  name="stock" required  lay-verify="required" placeholder="请输入商品库存" autocomplete="off" class="layui-input input-radius-20px" style="width:128px;">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" >商品分类：</label>
					    		<div class="layui-input-block">
							       <select id="categoryId" name="categoryId">
							       		
							       </select>
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" >商品状态：</label>
					    		<div class="layui-input-block">
							       <input type="radio" name="productStatus" value="1" title="在售" checked>
      								<input type="radio" name="productStatus" value="0" title="下架" >
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" >商品图片：</label>
					    		<div class="layui-input-block">
					    			<ul id="product_subimages">
					    				<li id="product-add">
					    					<div class="product-image-item">
					    						<a class="product-image-add">
						    						<i class="layui-icon layui-icon-add-circle"></i>
					    						</a>
					    					</div>
					    				</li>
					    			</ul>
							       <input id="product_image_file" accept="image/gif, image/jpeg, image/png"  type="file" style="display: none;">
							    </div>
					    	</div>
					    	
					    	
					    	<div class="layui-form-item">
							     <input  type="text" id="subimages" name="subimages" >
							     <input  type="text" id="productDetail" name="detail"  style="display:none;">
					    		<div id="summernote" class="layui-input-block">
							    </div>
					    	</div>
					    	
			    	<div class="layui-form-item" style="margin-top:50px;">
				    	<div class="layui-input-block" style="margin:0;text-align: center;">
					      <button id="btn_submitProduct" lay-submit lay-filter="product_form" class="layui-btn input-radius-20px" style="width:200px;">保存</button>
					    </div>
					  </div>
					  
			    </form>
			    
			    </div>
			</div>
			<script type="text/javascript" src="/EyuShopPortal/js/manage/save_or_update_product.js"></script>
</body>			
</html>