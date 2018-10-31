<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
				<div class="layui-row">
					<button id="btn_returnToRepertory" class="layui-btn layui-btn-sm" style="width:35px;height:35px;border-radius:50%;">
						<i class="layui-icon layui-icon-return" style=""></i>
					</button>
					<span style="font-size:15px;color:#444;">返回记录列表</span>
				</div>
				<form class="layui-form" style="margin-top:25px;">
					
			    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-username" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							      <input  type="text" id="shipping_receiverName" name="productId" required  lay-verify="required" placeholder="产品编号" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-senior" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverPhone" name="unit" required  lay-verify="required" placeholder="计算单位" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-cellphone" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverMobile"  name="unitPrice" required  lay-verify="required" placeholder="单价" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-flag" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverProvince" name="recordAmount" required  lay-verify="required" placeholder="数量" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-console" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverCity" name="provider" required  lay-verify="receiverCity" placeholder="提供商" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-log" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       	<input type="radio" name="recordType" value="0" title="进货" checked>
      								<input type="radio" name="recordType" value="1" title="出货">
							    </div>
					    	</div>
					    	
			    	
			    	<div class="layui-form-item">
				    	<div class="layui-input-block" style="margin:0;text-align: center;">
					      <button lay-submit lay-filter="btn_submitRepertoryRecord" class="layui-btn input-radius-20px" style="width:200px;">完成</button>
					    </div>
					  </div>
			    </form>

</html>