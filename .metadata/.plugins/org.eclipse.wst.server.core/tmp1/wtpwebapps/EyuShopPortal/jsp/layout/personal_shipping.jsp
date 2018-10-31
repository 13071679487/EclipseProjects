<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style type="text/css">
	 .shipping-item table thead tr{
			background-color:#ddd;
			color:rgba(250,250,250,.8);
			padding:0 5px;
		}
		
		
		.shipping-item table tbody tr td li{
			margin-top:2px;
		}

</style>
</head>
		<div class="layui-row">
		<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
			<h4 style="color:rgba(80,80, 80, .7);">收货地址管理</h4>
		</div>
	</div>
	
	<div class="layui-row shipping-item">
		<div class="layui-col-md12">
			<table class='layui-table' style="width:100%;">
			  <thead>
			    <tr style="padding:10px 10px;background-color:#009688">
			      <th >收货人</th>
			      <th >联系方式1</th>
			      <th >联系方式2</th>
			      <th >地址</th>
			      <th >邮编</th>
			      <th >操作</th>
			    </tr>
			  </thead>
			  <tbody id="shipping_list_table">
			  	
			  </tbody>
			</table>
		</div>
	</div>
	
	<div class="layui-row" style="margin-top:50px;">
		<div class="layui-col-md12" style="text-align: center;">
			<button id="btn_shippingModal" class="layui-btn input-radius-20px" style="width:200px;"><i class="layui-icon layui-icon-add-circle-fine"></i> 新建地址</button>
		</div>
	</div>
	
	<script type="text/javascript"
	src="/EyuShopPortal/js/layout/personal_shipping.js"></script>
</html>