<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
			<div class="layui-row">
				<div class="layui-col-md2" style="border-left:3px solid #009688;padding:10px;">
					<h4 style="color:rgba(80,80, 80, .7);">支付页面</h4>
				</div>
			</div>
			
			<div class="layui-row" style="margin-top:20px;">
				<h3 style="color:rgba(80,80, 80, .7);">订单编号：<span id="alipay_orderNo" style="color:rgba(80,80, 80, .7)"></span></h3>
			</div>
			
			<div id="alipay_content" class="layui-row" style="margin-top:100px;text-align: center">
				<img id="alipay_qr_code" alt="" src="" style="height:200px;width:200px;background-color:gray;">
				<h4 style="color:rgba(80,80, 80, .7);margin-top:10px;text-align: center;">Tips:打开支付宝即可进行扫码支付</h4>
			</div>
			
<script type="text/javascript"
	src="/EyuShopPortal/js/modules/module_alipay.js"></script>	
</html>