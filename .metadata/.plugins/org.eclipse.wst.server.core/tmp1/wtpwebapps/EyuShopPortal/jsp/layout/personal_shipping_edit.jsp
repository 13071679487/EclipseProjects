<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
				<div class="layui-row">
					<button id="btn_returnToShipping" class="layui-btn layui-btn-sm" style="width:35px;height:35px;border-radius:50%;">
						<i class="layui-icon layui-icon-return" style=""></i>
					</button>
					<span style="font-size:15px;color:#444;">返回地址列表</span>
				</div>
				<form class="layui-form" style="margin-top:25px;">
					<div class="layui-form-item" style="display:none;">
					    		<div class="layui-input-block">
							       <input  type="text" id="shippingId"  name="shippingId">
							       <input  type="text" id="userId"  name="userId" value="${currentUser.userId }">
							    </div>
					    	</div>
			    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-username" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							      <input  type="text" id="shipping_receiverName" name="receiverName" required  lay-verify="required" placeholder="请输入收货人姓名" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-senior" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverPhone" name="receiverPhone" required  lay-verify="required" placeholder="固定电话" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-cellphone" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverMobile"  name="receiverMobile" required  lay-verify="required" placeholder="手机号码" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-flag" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverProvince" name="receiverProvince" required  lay-verify="required" placeholder="所在省" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-console" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverCity" name="receiverCity" required  lay-verify="receiverCity" placeholder="所在城市" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-template-1" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverDistrict" name="receiverDistrict" required  lay-verify="required" placeholder="所在区/镇" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-location" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverAddress" name="receiverAddress" required  lay-verify="required" placeholder="详细地址" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-fonts-code" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="shipping_receiverZip" name="receiverZip" required  lay-verify="required" placeholder="邮编" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
			    	
			    	<div class="layui-form-item">
				    	<div class="layui-input-block" style="margin:0;text-align: center;">
					      <button lay-submit lay-filter="btn_submitShipping" class="layui-btn input-radius-20px" style="width:200px;">完成</button>
					    </div>
					  </div>
			    </form>

</html>