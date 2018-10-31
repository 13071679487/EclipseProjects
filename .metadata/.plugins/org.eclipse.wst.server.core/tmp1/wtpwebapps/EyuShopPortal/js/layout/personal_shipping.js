$(function(){
	personal_shippingCallback();
})

/**
 * 初始化函数
 */
function personal_shippingCallback() {
	$("#personal_menu").children("li").removeClass("layui-this");
	$('#personal_shipping').addClass("layui-this");
	getShippingList();
}

/**
 * 获取收货地址列表
 */
function getShippingList() {
	$.ajax({
		url : remotePath + "/shipping/list",
		type : "GET",
		success : function(result) {
			if (result.code == 100) {
				buildShippingList(result.data);
			} else {
				$("#content").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}

/**
 * 构建收货地址列表
 * 
 * @param data
 */
function buildShippingList(data) {
	$("#shipping_list_table").empty();
	$.each(
					data,
					function(index, item) {
						// 收货人姓名
						var username = $("<span></span>").empty().append(
								item.receiverName);
						var usernameEle = $("<td></td>").append(username);

						// 收货人固定电话
						var phone = $("<span></span>").empty().append(
								item.receiverPhone);
						var phoneEle = $("<td></td>").append(phone);

						// 收货人手机号码
						var mobile = $("<span></span>").empty().append(
								item.receiverMobile);
						var mobileEle = $("<td></td>").append(mobile);

						// 收货人地址
						var address = $("<span></span>").empty().append(
								item.receiverProvince + item.receiverCity
										+ item.receiverDistrict
										+ item.receiverAddress);
						var addressEle = $("<td></td>").append(address);

						// 邮编
						var receiverZip = $("<span></span>").empty().append(
								item.receiverZip);
						var receiverZipEle = $("<td></td>").append(receiverZip);

						// 操作选项

						var editEle = $("<li></li>")
								.append(
										$("<button></button>")
												.addClass(
														"layui-btn  layui-btn-xs btn-editShipping")
												.append("编辑"));
						var deleteEle = $("<li></li>")
								.append(
										$("<button></button>")
												.addClass(
														"layui-btn layui-btn-danger layui-btn-xs btn-deleteShipping")
												.append("删除"));
						var opUl = $("<ul></ul>").prop("style",
								"list-style:none;").append(editEle).append(
								deleteEle);
						var opEle = $("<td></td>").append(opUl);

						var trEle = $("<tr></tr>").addClass("shipping_item")
								.attr("shippingId", item.shippingId).append(
										usernameEle).append(phoneEle).append(
										mobileEle).append(addressEle).append(
										receiverZipEle).append(opEle);

						$("#shipping_list_table").append(trEle);
					})
}

/**
 * 点击了新建收货地址
 */
$(document).on("click", "#btn_shippingModal", function(event) {
	console.log("click the create shipping")
	$("#content").empty();
	$("#content").load(path + "/jsp/layout/personal_shipping_edit.jsp", {
		"type" : 1
	}, function() {

	});

})

/**
 * 点击了编辑收货地址
 */
$(document).on("click", ".btn-editShipping", function(event) {
	console.log("click the update shipping")
	var shippingId = $(this).parents(".shipping_item").attr("shippingId");
	$("#content").empty();
	$("#content").load(path + "/jsp/layout/personal_shipping_edit.jsp", {
		"type" : 1
	}, function() {
		updateShipping(shippingId);
	});
	event.stopPropagation();
})

/**
 * 点击了删除收货地址
 */
$(document).on("click", ".btn-deleteShipping", function(event) {
	console.log("click the new shipping")
	var deleteShippingId = $(this).parents(".shipping_item").attr("shippingId");
	layer.confirm('确认删除吗?', {
		icon : 3,
		title : '删除收货地址'
	}, function(index) {
		// $(deleteShipping).parents(".shipping-item").fadeOut('slow');
		console.log("need to delete :" + deleteShippingId);
		deleteShipping(deleteShippingId);
		layer.close(index);
	});
	event.stopPropagation();
})

/**
 * 新建收货地址
 */
function createShipping() {

}

/**
 * 编辑收货地址
 */
function updateShipping(shippingId) {
	$.ajax({
		url : remotePath + "/shipping/info",
		type : "GET",
		data : {
			"shippingId" : shippingId
		},
		success : function(result) {
			if (result.code == 100) {
				initFormData(result.data);
			} else {
				$("#content layui-form").empty().load(path+"/jsp/widget/error404.jsp");
			}
		}
	})
}


/**
 * 初始化表单信息
 * 
 * @param data
 */
function initFormData(data) {
	$("#shippingId").val(data.shippingId == null ? "" : data.shippingId);
	$("#shipping_receiverName").val(
			data.receiverName == null ? "" : data.receiverName);
	$("#shipping_receiverPhone").val(
			data.receiverPhone == null ? "" : data.receiverPhone);
	$("#shipping_receiverMobile").val(
			data.receiverMobile == null ? "" : data.receiverMobile);
	$("#shipping_receiverProvince").val(
			data.receiverProvince == null ? "" : data.receiverProvince);
	$("#shipping_receiverCity").val(
			data.receiverCity == null ? "" : data.receiverCity);
	$("#shipping_receiverDistrict").val(
			data.receiverDistrict == null ? "" : data.receiverDistrict);
	$("#shipping_receiverAddress").val(
			data.receiverAddress == null ? "" : data.receiverAddress);
	$("#shipping_receiverZip").val(
			data.receiverZip == null ? "" : data.receiverZip);
}

$(document).on("click", "#btn_returnToShipping", function() {
	// $("#content").empty();
	// $("#content").load(path+"/jsp/layout/personal_shipping.jsp",{},function(){
	// personal_shippingCallback();
	// });
	window.location.reload();
})

/**
 * 删除收货地址
 * 
 * @param shippingId
 */
function deleteShipping(shippingId) {
	$.ajax({
		url : remotePath + "/shipping/delete",
		type : "POST",
		data : {
			"shippingId" : shippingId
		},
		success : function(result) {
			if (result.code == 100) {
				getShippingList();
			} else {
				alert("删除失败");
			}
		}
	})
}