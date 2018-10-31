<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
	<!-- 牢记，先引入js再引入css -->
<!-- 引入jquery -->
<script type="text/javascript"
	src="${path}/bootstrap3/js/jquery-1.12.4.min.js"></script>
<!-- 引入js文件 -->
<script
	src="${path }/bootstrap3/js/bootstrap.min.js"></script>
<!-- 引入样式 -->
<link href="${path}/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
	
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-md-12 page-header">
				<h1>Spring+Struts2+Hibernate</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-10">
				<button type="button" class="btn btn-primary" id="btn_addEmp" >添加</button>
				<button type="button" class="btn btn-danger" id="btn_deleteEmp">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							<th>Uid</th>
							<th>Name</th>
							<th>email</th>
							<th>Department</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4" id="page_info">
			
			</div>
			<div class="col-md-6 col-md-offset-1" id="page_nav">
				
			</div>

		</div>
	</div>
	
	<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		  	<!-- 姓名  -->
		    <label class="col-sm-2 control-label">Name</label>
		    <div class="col-sm-10">
		      <input type="text" name="name"class="form-control" id="input_name" placeHolder="name">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <!-- Email -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-10">
		      <input type="email" name="email" class="form-control" id="input_email" placeHolder="email">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <!-- department -->
		   <div class="form-group">
		    <label class="col-sm-2 control-label">Department</label>
		    <div class="col-sm-10">
		      <input type="text" name="dept" class="form-control" id="input_dept" placeHolder="department">
		      <span class="help-block"></span>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn_save_emp">保存</button>
      </div>
    </div>
  </div>
</div>

	<!-- 员工修改的模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		  	<!-- 姓名  -->
		    <label class="col-sm-2 control-label">Name</label>
		    <div class="col-sm-10">
		      <input type="text" name="name" class="form-control" id="input_update_name" placeHolder="name">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <!-- Email -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-10">
		      <input type="email" name="email" class="form-control" id="input_update_email" placeHolder="email">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <!-- department -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">Department</label>
		    <div class="col-sm-10">
		      <input type="text" name="dept" class="form-control" id="input_update_dept" placeHolder="department">
		      <span class="help-block"></span>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn_update_emp">更新</button>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">

	var currentPage,totalPage;

	$(function(){
		to_page(1);
	})
	function to_page(pageNum){
		currentPage=pageNum;
		$.ajax({
			url:"employeeAction-list",
			data:"pn="+pageNum,
			type:"POST",
			success:function(jsonData){
				var result=eval("("+jsonData+")");
				 build_emps_table(result);
				 build_page_info(result);
				 build_pagenav_info(result);
			}
		});
	}
	
	function build_page_info(result){
		$("#page_info").empty();
		$("#page_info").append("总"+result.extend.pageInfo.totalPage+"共页，总"+result.extend.pageInfo.totalRecord+"条记录");
		totalPages=result.extend.pageInfo.pages;
	}
	
	function build_pagenav_info(result){
		$("#page_nav").empty();
		var ul=$("<ul></ul>").addClass("pagination");
		//首页
		var firstPage=$("<li></li>").append($("<a></a>").append("First").attr("href","#"));
		//前一页
		var previousPage=$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
		if(result.extend.pageInfo.hasPrevious==false){
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
		
		ul.append(firstPage).append(previousPage);
		
		//后一页
		var nextPage=$("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
		//尾页
		var lastPage=$("<li></li>").append($("<a></a>").append("Last").attr("href","#"));
		if(result.extend.pageInfo.hasNext==false){
			nextPage.addClass("disabled");
			lastPage.addClass("disabled");
		}else{
			nextPage.click(function(){
				to_page(result.extend.pageInfo.pageNum+1);
			});
			lastPage.click(function(){
				to_page(result.extend.pageInfo.totalPage)
			});
		}
		
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
	
	function build_emps_table(result){
			$("#emps_table tbody").empty();
			$.each(result.extend.pageInfo.dataList,function(index,item){
				var checkboxTd=$("<td><input type='checkbox' class='check_item'/></td>");
				var empIdTd=$("<td></td>").append(item.id);
				var empNameTd=$("<td></td>").append(item.name);
				var empEmailTd=$("<td></td>").append(item.email);
				var empDeptTd=$("<td></td>").append(item.dept);
				var btnEdit=$("<button></button>").addClass("btn btn-warning btn-sm btn_update")
							.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				btnEdit.attr("id",item.id);
				//$(btnEdit).click=edit_emp(item);
				var btnDelete=$("<button></button>").addClass("btn btn-danger btn-sm btn_delete")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				btnDelete.attr("empId",item.id);
				//$(btnDelete).click=delete_emp(item);
				var btnTd=$("<td></td>").append(btnEdit).append("&nbsp;").append(btnDelete);
				
				$("<tr></tr>")
				.append(checkboxTd)
				.append(empIdTd)
				.append(empNameTd)
				.append(empEmailTd)
				.append(empDeptTd)
				.append(btnTd)
				.appendTo("#emps_table tbody");
			})
		}
	
		$("#btn_addEmp").click(function(){
			reset_form("#empAddModal form");
			 $("#empAddModal").modal({
				 backgrop:'true'
			 });
		}); 
		
		//1、我们是按钮创建之前就绑定了click，所以绑定不上。
		//1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
		//jquery新版没有live，使用on进行替代
		$(document).on("click",".btn_update",function(){
			reset_form("#empUpdateModal form");
			
			//根据id查询员工信息
			getEmp($(this).attr("id"));
				
			 //吧员工的id传递过去
			$("#btn_update_emp").attr("empId",$(this).attr("id"));
			$("#empUpdateModal").modal({
				backdrop:"true"
			});
		});
		
		function reset_form(ele){
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		
		//单个删除
		$(document).on("click",".btn_delete",function(){
			var empName=$(this).parents("tr").find("td:eq(2)").text();
			if(confirm("Delete sure?The "+empName)){
				$.ajax({
					url:"${path}/employeeAction-delete",
					data:"id="+$(this).attr("empId"),
					type:"POST",
					success:function(result){
						to_page(0);
						//to_page(currentPage);
					}
				});
			}		
		});
		
		function getEmp(id){
			$.ajax({
				url:"${path}/employeeAction-get",
				data:"id="+id,
				type:"GET",
				success:function(result){
					var rs=eval("("+result+")");
					if(rs.code==100){
						var emp=rs.extend.emp;
						$("#input_update_name").val(emp.name);
						$("#input_update_email").val(emp.email);
						$("#input_update_dept").val(emp.dept);
					}
				}
			})
		}
		
		/*
		点击保存的点击事件
	*/
	$("#btn_save_emp").click(function(){
		$.ajax({
			url:"${path}/employeeAction-save",
			type:"POST",
			data:$("#empAddModal form").serialize(),
			success:function(result){
				console.log(result);
				var rs=eval("("+result+")");
				if(rs.code==100){
					$("#empAddModal").modal('hide');
					//发送ajax去到最后一页
					//to_page(totalPages+1);
					to_page(0);
				}else{
					
				}
			},
		})
	})
	
	//点击更新员工信息
		$("#btn_update_emp").click(function(){
			//发送请求更新员工
			$.ajax({
				url:"${path}/employeeAction-update?id="+$("#btn_update_emp").attr("empId"),
				type:"POST",
				data:$("#empUpdateModal form").serialize()+"",
				success:function(result){
					var rs=eval("("+result+")");
					if(rs.code==100){
						$("#empUpdateModal").modal('hide');
						to_page(0);
					}
				}
			});
		});
		
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
	
	$("#btn_deleteEmp").click(function(){
		var length=$(".check_item:checked").length;
		if(length>0){
			var names="",ids="";
			$.each($(".check_item:checked"),function(data){
				names+=$(this).parents("tr").find("td:eq(2)").text();
				names+="\t";
				
				ids+=$(this).parents("tr").find("td:eq(1)").text()+"-";
			})
			//去除最后一个“-”
			ids=ids.substring(0,ids.length-1);
			if($(confirm("Delete sure?Total "+length+" records\n"+names))){
				$.ajax({
					url:"${path}/employeeAction-deleteByIds",
					data:"ids="+ids,
					type:"POST",
					success:function(result){
						to_page(0);
					}
				})
			}
		}
	});
		
</script>
</body>
</html>