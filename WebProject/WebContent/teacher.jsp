<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师表维护</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!-- web路径 
不以/开头的就是相对路径，以当前资源的路径为基准，找资源经常容易出问题
以/开头 的相对路径，找资源，以服务器的路径为标准（http:/localhost:3306）+需要加上项目名
-->
	<!-- 牢记，先引入js再引入css -->
<!-- 引入jquery -->
<link href="${path}/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${path}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 引入js文件 -->
<script
	src="${path }/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<button type="button" class="btn btn-primary" id="btn_addTeacher" >添加</button>
				<button type="button" class="btn btn-danger" id="btn_deleteTeacher">批量删除</button>
			</div>
			
			
			<div class="col-md-1" style="padding:0;margin:0;text-align: right;width:100px;">
				<select class="form-control" style="padding:0 10px;">
					<option value="1">教工号</option>
					<option value="2">姓名</option>
				</select>
			</div>
			<div class="col-md-2" style="padding:0;margin:0;text-align: left;">
				<div class="input-group" >
				      <input type="text" class="form-control" id="searchCondition"/>
				      <span class="input-group-btn">
				        <button class="btn btn-default" type="button">搜索</button>
				      </span>
				</div>
			</div>
			
		</div>
		<div class="row" style="min-height: 500px;">
			<div class="col-md-12">
				<table class="table table-hover table-condensed table-striped" id="users_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>-
		
	<div class="row" >
			<div class="col-md-4" id="page_info">
			
			</div>
			<div class="col-md-6 col-md-offset-1" id="page_nav">
				
			</div>

	</div>
</div>

<!-- 学生添加的模态框 -->
<div class="modal fade" id="teacherAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">教师添加</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  	<div class="form-group">
			    <label class="col-sm-2 control-label">教师编号</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="input_account">
			    </div>
			  </div>
			  <!-- 姓名 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="input_teachername">
			    </div>
			  </div>
		
			  
		  <!-- gender -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">性别</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="teacherGender" id="gender1_add_input" value="m" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="teacherGender" id="gender2_add_input" value="f"> 女
				</label>
		    </div>
		  </div>

		  <!-- 职称 -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">职称</label>
		    <div class="col-sm-6">
		      <input type="text" class="form-control" id="input_teacherGender">
		    </div>
		  </div>
		  
		   <!-- 职称 -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">学院ID</label>
		    <div class="col-sm-6">
		      <input type="text" class="form-control" id="input_teacherGender">
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn_save_teacher">保存</button>
      </div>
    </div>
  </div>
</div>

<!-- 员工修改的模态框 -->
<div class="modal fade" id="teacherUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">教师修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
       <!-- ID -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">教师编号</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="input_account">
			    </div>
			  </div>
			  <!-- 姓名 -->
			  <div class="form-group">
			    <label class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="input_teachername">
			    </div>
			  </div>
		
			  
		  <!-- gender -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">性别</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="teacherGender" id="gender1_add_input" value="m" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="teacherGender" id="gender2_add_input" value="f"> 女
				</label>
		    </div>
		  </div>

		  
		  <!-- 职称 -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">职称</label>
		    <div class="col-sm-6">
		      <input type="text" class="form-control" id="input_teacherGender">
		    </div>
		  </div>
		  
		   <!-- 职称 -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">学院ID</label>
		    <div class="col-sm-6">
		      <input type="text" class="form-control" id="input_teacherGender">
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn_update_teacher">更新</button>
      </div>
    </div>
  </div>
</div>

</body>
<script type="text/javascript">

$("#btn_addTeacher").click(function(){
	 reset_form("#teacherAddModal form");
	
	$("#teacherAddModal").modal({
		//点击模态框外部消失
		backdrop:"true"
	});
});


function reset_form(ele){
	$(ele)[0].reset();
	$(ele).find("*").removeClass("has-error has-success");
	$(ele).find(".help-block").text("");
}

function build_teachers_table(result){
	$("#teachers_table tbody").empty();
	var teacherList=result.extend.pageInfo.list;
	$.each(teacherList,function(index,item){
		var checkboxTd=$("<td><input type='checkbox' class='check_item'/></td>");
		var accountTd=$("<td></td>").append(item.teacherAccount);
		var nameTd=$("<td></td>").append(item.teacherName);
		var genderTd=$("<td></td>").append(item.teacherGender=='m'?'男':'女');
		var createTimeTd=$("<td></td>").append(formatDate(item.teacherCreatetime));
		var roleTd=$("<td></td>").append(item.role.roleName);
		var btnEdit=$("<button></button>").addClass("btn btn-warning btn-sm btn_update")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
		btnEdit.attr("id",item.teacherId);
		var btnDelete=$("<button></button>").addClass("btn btn-danger btn-sm btn_delete")
		.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
		btnDelete.attr("teacherId",item.teacherId);
		var btnTd=$("<td></td>").append(btnEdit).append("&nbsp;").append(btnDelete);
		
		$("<tr></tr>")
		.append(checkboxTd)
		.append(accountTd)
		.append(nameTd)
		.append(genderTd)
		.append(createTimeTd)
		.append(roleTd)
		.append(btnTd)
		.attr("teacherId",item.teacherId)
		.appendTo("#teachers_table tbody");
	})
}


//解析显示分页条
function build_page_nav(result){
	$("#page_nav").empty();
	var ul=$("<ul></ul>").addClass("pagination");
	//首页
	var firstPage=$("<li></li>").append($("<a></a>").append("First").attr("href","#"));
	//前一页
	var previousPage=$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
	if(result.extend.pageInfo.hasPreviousPage==false){
		firstPage.addClass("disabled");
		previousPage.addClass("disabled");
	}else{
		firstPage.click(function(){
			to_page(1);
		});
		previousPage.click(function(){
			to_page(result.extend.pageInfo.pageNum-1);
		}); 
	}
	//后一页
	var nextPage=$("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
	//尾页
	var lastPage=$("<li></li>").append($("<a></a>").append("Last").attr("href","#"));
	if(result.extend.pageInfo.hasNextPage==false){
		nextPage.addClass("disabled");
		lastPage.addClass("disabled");
	}else{
		nextPage.click(function(){
			to_page(result.extend.pageInfo.pageNum+1);
		});
		lastPage.click(function(){
			to_page(result.extend.pageInfo.pages)
		});
	}
	ul.append(firstPage).append(previousPage);
	$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
		var numLi=$("<li></li>").append($("<a></a>").append(item));
		if(result.extend.pageInfo.pageNum==item){
			numLi.addClass("active");
		}
		numLi.click(function(){
			to_page(item);
		});
		ul.append(numLi);
	});
	
	ul.append(nextPage);
	ul.append(lastPage);
	
	var navEle=$("<nav></nav>").append(ul);
	//$("#page_nav").append(navEle);
	navEle.appendTo($("#page_nav"));
}
function to_page(pageNum){
	currentPage=pageNum;
	$.ajax({
		url:"${path}/teachers",
		data:{'pn':pageNum,'size':8},
		type:"GET",
		success:function(result){
			console.log(result);
			 build_teachers_table(result);
			 build_page_nav(result);
		}
	})
}

$(document).on("click",".btn_update",function(){
	reset_form("#teacherUpdateModal form");
	
	//根据id查询员工信息
	getTeacher($(this).attr("id"));
		
	 //吧员工的id传递过去
	$("#btn_update_teacher").attr("teacherId",$(this).attr("id"));
	$("#teacherUpdateModal").modal({
		backdrop:"true",
		keyborad:true
	});
});

/*
点击保存的点击事件
*/
$("#btn_save_teacher").click(function(){
	/*
	if(!validate_add_teacher()){
		return false;
	}
	*/
	
	$.ajax({
		url:"${path}/teacher",
		type:"POST",
		data:$("#teacherAddModal form").serialize(),
		success:function(result){
			console.log(result);
			if(result.code==100){
				$("#teacherAddModal").modal('hide');
				//发送ajax去到最后一页
				to_page(totalPages+1);
			}else{
				console.log(result);
			}
		},
	})
})

$("#check_all").click(function(){
	//如果是要获取dom原生的属性应该使用prop,如果是要获取自定义属性就用attr
	var check=$("#check_all").prop("checked");
	$(".check_item").prop("checked",check);
});

//当所有checkbox都选了，就应该给check_all也给选上
$(document).on("click",".check_item",function(){
	//判断当前页面的check_item是否已全选
	var allChecked=$(".check_item:checked").length==$(".check_item").length;
	$("#check_all").prop("checked",allChecked);
});

$("#btn_deleteTeacher").click(function(){
	var length=$(".check_item:checked").length;
	
	if(length>0){
		var names="",ids="";
		$.each($(".check_item:checked"),function(data){
			names+=$(this).parents("tr").find("td:eq(2)").text();
			names+="\t";
			ids+=$(this).parents("tr").attr("teacherid")+"-";
		})
		//去除最后一个“-”
		ids=ids.substring(0,ids.length-1);
		if($(confirm("Delete sure?Total "+length+" records\n"+names))){
			$.ajax({
				url:"${path}/teacher/"+ids,
				type:"DELETE",
				success:function(result){
					to_page(currentPage);
				}
			})
		}
	}
	
});
</script>
</html>