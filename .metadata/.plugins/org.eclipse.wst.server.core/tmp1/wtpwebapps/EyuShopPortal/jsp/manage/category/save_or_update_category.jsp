<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

	#category_form .layui-select-title i{
	 right:120px;
	}

</style>
</head>
						<div class="layui-row">
							<button id="btn_returnToCategory" class="layui-btn layui-btn-sm" style="width:35px;height:35px;border-radius:50%;">
								<i class="layui-icon layui-icon-return" style=""></i>
							</button>
							<span style="font-size:15px;color:#444;">返回标签列表</span>
						</div>

					<div class="layui-row" style="margin-top:25px;">
						<div class="layui-col-md8 layui-col-md-offset2">
							
						<form id="category_form" class="layui-form" action="" style="margin-top:25px;">
			    			<div class="layui-form-item" style="display:none;">
					    		<div class="layui-input-block">
							      <input  type="text" id="categoryId" name="categoryId" >
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-senior" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       <input  type="text" id="categoryName" name="categoryName" required  lay-verify="required" placeholder="标签名字" autocomplete="off" class="layui-input input-radius-20px">
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-note" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							      <select id="parentId" name="parentId" style="width:200px;">
							      	<option value="1">东西呢</option>
							      </select>
							    </div>
					    	</div>
					    	
					    	<div class="layui-form-item">
					    	<label class="layui-form-label" ><i class="layui-icon layui-icon-log" style="font-size: 20px; color: #009688;"></i></label>
					    		<div class="layui-input-block">
							       	<input type="radio" name="categoryStatus" value="1" title="可用"/>
      								<input type="radio" name="categoryStatus" value="0" title="不可用"/>
							    </div>
					    	</div>
			    	
			    	<div class="layui-form-item" style="margin-top:50px;">
				    	<div class="layui-input-block" style="margin:0;text-align: center;">
					      <button lay-submit lay-filter="category_form" class="layui-btn input-radius-20px" style="width:200px;">保存</button>
					    </div>
					  </div>
					  
			    </form>
			    
			    </div>
			</div>
</html>