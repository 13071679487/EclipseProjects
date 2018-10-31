<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
	
	#product_table tbody tr img{
		width:42px;
		height:42px;
	}
	
	#product_table tbody tr td{
	text-align: center;
	}
	
	</style>
</head>
			<div class="layui-row">
				<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
					<h4 style="color:rgba(80,80, 80, .7);">商品管理</h4>
				</div>
			</div>
			
			<div class="layui-row" style="margin-top:25px;">
				<table class='layui-table' id="product_table" lay-filter="category_table" style="width:96%;">
					<thead>
						<tr>
						      <th >编号</th>
						      <th >图片</th>
						      <th >商品名称</th>
						      <th >分类ID</th>
						      <th >价格</th>
						      <th >库存</th>
						      <th >状态</th>
						      <th >操作</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
				
			</div>
			
			<div class="layui-row" style="text-align: center;margin-top:50px;">
				<button id="btn_createProduct" class="layui-btn input-radius-20px" style="width:200px;">新建商品</button>
			</div>
			
			<div class="layui-row" style="margin-top:50px;">
				<jsp:include page="/jsp/widget/page_nav.jsp"></jsp:include>
			</div>
			
			<script type="text/javascript">
			var tempDiv;
			var currentPagenum=1;

			$(function(){
				manage_productCallback();
			})

			/**
			 * 初始化函数
			 */
			function manage_productCallback(){
				getProductList(null,0,1);
			}
			</script>
</html>