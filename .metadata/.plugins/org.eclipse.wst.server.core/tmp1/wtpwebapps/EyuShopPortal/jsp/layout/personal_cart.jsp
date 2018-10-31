<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/base.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
		table th{
			color:rgba(250,250,250,.8);
		}
		table tbody tr td{
			padding:5px;
			color:rgba(80,80, 80, .7);
		}
	</style>
</head>
	<div class="layui-row">
		<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
			<h4 style="color:rgba(80,80, 80, .7);">我的购物车</h4>
		</div>
	</div>
	
	<div class="layui-row" style="margin-top:15px;">
		<div class="layui-col-md12">
			<table class='layui-table' style="width:96%;" lay-skin="line">
			  <thead>
			    <tr style="padding:10px 10px;background-color:#009688">
			      <th ></th>
			      <th >商品</th>
			      <th >单价</th>
			      <th >数量</th>
			      <th >小计</th>
			      <th >操作</th>
			    </tr>
			  </thead>
			  <tbody id="cart_list_table">
			  	
			  	
			  	<tr id="calcSummary">
			  		<td>
			  			<input id="btn_selectAllCart" type="checkbox" name=""  lay-skin="primary"/>
			  			全选
			  		</td>
			  		
			  		<td></td>
			  		<td></td>
			  		
			  		<td>
			  			共<span id="cart_quantity" style="font-size:16px;color:red;padding:0 3px;"></span>件商品
			  		</td>
			  		
			  		<td>
			  			合计<span id="cart_totalPrice" style="font-size:16px;color:red;padding:0 3px;"></span>
			  		</td>
			  		
			  		<td style="padding:0;">
			  			<button id="btn_calcCart" class="layui-btn layui-btn-danger" style="width:100%;height:100%;background-color:#CD0000">结算</button>
			  		</td>
			  		
			  	</tr>
			  	
			  </tbody>
			</table>
		</div>
	</div>
</html>