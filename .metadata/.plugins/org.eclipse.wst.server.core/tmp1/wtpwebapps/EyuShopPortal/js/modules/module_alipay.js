var timeOpen = true;
var totalWaitTime=0;

function module_alipayCallback(orderNo){
	console.log("module_alipayCallback"+orderNo);
	$("#alipay_orderNo").empty().append(orderNo);
	pay(orderNo);
}

function pay(orderNo){
	$.ajax({
		url:remotePath+"/order/pay",
		type:"POST",
		data:{"orderNo":orderNo},
		success:function(result){
			if(result.code ==100){
				initQRCode(result.data);
			}else{
				layer.msg("生成支付二维码失败");
			}
		}
	})
}

function initQRCode(data){
	$("#alipay_qr_code").prop("src",data.QRUrl);
	checkHasPaid(data.orderNo);
}

function checkHasPaid(orderNo){
//	$("#alipay_orderNo").everyTime('2s',function(){
//		timerFun();
//	})
	setTimeout(function(){timerFun(orderNo)},3000);
}

function timerFun(orderNo){
	$.ajax({
		url:remotePath+"/order/haspaid",
		type:"GET",
		data:{"orderNo":orderNo},
		success:function(result){
			if(result.code ==100){
				if(result.data==true){
					timeOpen=false;
					layer.msg('支付成功，等待商家发货')
//					$("#alipay_content").empty().append("支付成功");
				}else{
					if(timeOpen){
						totalWaitTime=totalWaitTime+3;
						if(totalWaitTime>300){
							timeOpen=false;
							layer.msg("长期未处理，二维码已失效");
						}
						setTimeout(function(){timerFun(orderNo)},3000);
					}
				}
			}else{
				layer.msg(result.msg)
			}
		}
	})
}