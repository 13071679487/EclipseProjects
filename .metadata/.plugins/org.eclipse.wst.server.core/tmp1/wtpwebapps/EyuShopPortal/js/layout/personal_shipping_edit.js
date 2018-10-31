function saveOrUpdateShipping(data){
	$.ajax({
		url:remotePath+"/shipping/save_or_update",
		type:"POST",
		data:data,
		success:function(result){
			if(result.code == 100){
				window.location.reload();
			}else{
				layer.msg("操作失败");
			}
		}
	})
}