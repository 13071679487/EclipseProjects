<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 引入样式 -->
<link href="/EyuShopPortal/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript"
	src="/EyuShopPortal/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript"
	src="/EyuShopPortal/js/common.js"></script>
	<script src="/EyuShopPortal/layui/layui.js"></script>
</head>
	<div class="layui-row">
		<div class="layui-col-md6 layui-col-md-offset3" style="text-align: center;padding:6px;">
			<div class="layui-row">
				<button id="btn_choosePic" class="layui-btn layui-btn-sm"><i class="layui-icon layui-icon-picture"></i>选择图片</button>
			</div>
			
			<input id="upload_usericon" type="file" name="file" accept="image/jpeg,image/jpg,image/png" style='display:none;'>
			
			<div style="margin-top:15px;">
				<img id="preview" class="layui-layout-circle" alt="" style="height:160px;width:160px;border-radius:50%;"/>
			</div>
			
			<div class="layui-row" style="margin-top:25px;">
				<button id="btn_ensureUpload" class="layui-btn layui-btn-sm" >确认修改</button>
				<!-- <button id="btn_cancelUpload" class="layui-btn layui-btn-sm" style="background-color:#EEE5DE">取消</button> -->
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	var files;
	
	var layer;
	layui.use('layer', function(){
		  layer = layui.layer;
		  
	}); 
	
	$("#btn_choosePic").on("click",function(){
		$("#upload_usericon").click();
	})
	
	$("#btn_ensureUpload").on("click",function(){
		if(files&&files[0]){
			upload(files);
		}
	})
	//监听所选择图片变化情况
	$("#upload_usericon").change(function(){
		if(this.files&&this.files[0]){
			var reader =new FileReader();
			reader.onload=function(evt){
				$("#preview").prop("src",evt.target.result);
			}
			reader.readAsDataURL(this.files[0]); 
			files=this.files;
		}
	})
	
	function upload(files){
		var formData = new FormData();  
	    formData.append("file", files[0]);  
	    $.ajax({  
	        data : formData,  
	        type : "POST",  
	        url : remotePath+"/user/upload", //图片上传出来的url，返回的是图片上传后的路径，http格式  
	        cache : false,  
	        contentType : false,  
	        processData : false,  
	        success: function(result) {//data是返回的hash,key之类的值，key是定义的文件名  
	        	if(result.code==100){
	        		layer.msg("上传成功");
	        	}else{
	        		layer.msg(result.msg);
	        	}
	        },  
	        error:function(){  
	        	layer.msg("请检查网络");
	        }  
	    });  
	}
	</script>
</html>