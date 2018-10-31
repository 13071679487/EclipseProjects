<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!-- web路径 
不以/开头的就是相对路径，以当前资源的路径为基准，找资源经常容易出问题
以/开头 的相对路径，找资源，以服务器的路径为标准（http:/localhost:3306）+需要加上项目名
-->


	<!-- 牢记，先引入js再引入css -->
<!-- 引入jquery -->
<script type="text/javascript"
	src="${path}/static/js/jquery-1.12.4.min.js"></script>
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
				<h1>Spring+SpringMVC+Mybatis</h1>
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
							<th>Gender</th>
							<th>Email</th>
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
		      <input type="text" name="empName"class="form-control" id="input_name" placeHolder="name">
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
		  <!-- gender -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">gender</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_add_input" value="n" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="gender2_add_input" value="f"> 女
				</label>
		    </div>
		  </div>
		  <!-- department -->
		   <div class="form-group">
		    <label class="col-sm-2 control-label">deptName</label>
		    <div class="col-sm-4">
		    	<!-- 部门提交部门id即可 -->
		      <select class="form-control" name="dId" id="dept_add_select">
		      </select>
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
		      <input type="text" name="empName"class="form-control" id="input_update_name" placeHolder="name" disabled>
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
		  <!-- gender -->
		  <div class="form-group">
		    <label class="col-sm-2 control-label">gender</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_update_input" value="n" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="gender2_update_input" value="f"> 女
				</label>
		    </div>
		  </div>
		  <!-- department -->
		   <div class="form-group">
		    <label class="col-sm-2 control-label">deptName</label>
		    <div class="col-sm-4">
		    	<!-- 部门提交部门id即可 -->
		      <select class="form-control" name="dId" id="dept_update_select">
		      </select>
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
	
		var totalPages,currentPage;
		//页面加载完成发送请求，显示数据
		$(function(){
			to_page(1);
		})
		
		
		function build_emps_table(result){
			$("#emps_table tbody").empty();
			var emps=result.extend.pageInfo.list;
			$.each(emps,function(index,item){
				var checkboxTd=$("<td><input type='checkbox' class='check_item'/></td>");
				var empIdTd=$("<td></td>").append(item.empId);
				var empNameTd=$("<td></td>").append(item.empName);
				var empGenderTd=$("<td></td>").append(item.gender=='n'?'男':'女');
				var empEmailTd=$("<td></td>").append(item.email);
				var empDeptTd=$("<td></td>").append(item.dept.deptName);
				var btnEdit=$("<button></button>").addClass("btn btn-warning btn-sm btn_update")
							.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				btnEdit.attr("id",item.empId);
				//$(btnEdit).click=edit_emp(item);
				var btnDelete=$("<button></button>").addClass("btn btn-danger btn-sm btn_delete")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				btnDelete.attr("empId",item.empId);
				//$(btnDelete).click=delete_emp(item);
				var btnTd=$("<td></td>").append(btnEdit).append("&nbsp;").append(btnDelete);
				
				$("<tr></tr>")
				.append(checkboxTd)
				.append(empIdTd)
				.append(empNameTd)
				.append(empGenderTd)
				.append(empEmailTd)
				.append(empDeptTd)
				.append(btnTd)
				.appendTo("#emps_table tbody");
			})
		}
		
		//解析显示分页信息
		function build_page_info(result){
			$("#page_info").empty();
			$("#page_info").append("总"+result.extend.pageInfo.pages+"共页，总"+result.extend.pageInfo.total+"条记录");
			totalPages=result.extend.pageInfo.pages;
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
		
		 $("#btn_addEmp").click(function(){
			 reset_form("#empAddModal form");
			
			 //发送ajax请求，查出部门信息，显示在下拉列表
			getDpets("#dept_add_select");
			$("#empAddModal").modal({
				//点击模态框外部消失
				backdrop:"true"
			});
		}); 
		
		function to_page(pageNum){
			currentPage=pageNum;
			$.ajax({
				url:"${path}/emps",
				data:"pn="+pageNum,
				type:"GET",
				success:function(result){
					/* console.log(result); */
					//解析并显示员工数据
					 build_emps_table(result);
					 build_page_info(result);
					 build_page_nav(result);
				}
			})
		}
		//查出部门信息，显示在下拉列表
		function getDpets(ele){
			//清空之前下拉列表的内容
			$(ele).empty();
			$.ajax({
				url:"${path}/depts",
				type:"GET",
				success:function(result){
					console.log(result);
					$.each(result.extend.depts,function(){
						var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
						optionEle.appendTo(ele);
					});
				}
			});
		}
		
		function reset_form(ele){
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		/*
			点击保存的点击事件
		*/
		$("#btn_save_emp").click(function(){
			if(!validate_add_emp()){
				return false;
			}
			if($("#btn_save_emp").attr("validate")=="error"){
				return false;
			}
			$.ajax({
				url:"${path}/emp",
				type:"POST",
				data:$("#empAddModal form").serialize(),
				success:function(result){
					console.log(result);
					if(result.code==100){
						$("#empAddModal").modal('hide');
						//发送ajax去到最后一页
						to_page(totalPages+1);
					}else{
						//show_validate_msg(ele, status, msg);						
						console.log(result);
						if(undefined !=result.extend.errorFields.email){
							show_validate_msg("#input_email", "error", result.extend.errorFields.email);
						}
						if(undefined !=result.extend.errorFields.empName){
							show_validate_msg("#input_email", "error", result.extend.errorFields.empName);
						}
					}
				},
			})
		})
		//检验姓名和邮箱字段
		function validate_add_emp(){
			//1.拿到要校验的数据,使用正则表达式
			var name=$("#input_name").val();
			//6-16位数字加字母，或者2-5位中文
			var regName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(name)){
				show_validate_msg("#input_name","error","格式为6~16位字母加数字，或者2~5位汉字");
				return false;
			}else{
				show_validate_msg("#input_name","success","");
			}
			var email=$("#input_email").val();
			var regEmail= /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				show_validate_msg("#input_email","error","邮箱格式错误");
				return false;
			}else{
				show_validate_msg("#input_email","success","");
			}
			return true;
		}
		
		/*
			显示检验信息
		*/
		function show_validate_msg(ele,status,msg){
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success"==status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error"==status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		/*
			当姓名输入框发生改变，发送请求检验姓名是否可用
		*/
		$("#input_name").change(function(){
			var empName=$("#input_name").val();
			$.ajax({
				url:"${path}/checkemp",
				data:"empName="+empName,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#input_name","success","");
						$("#btn_save_emp").attr("valite","success");
					}else{
						show_validate_msg("#input_name","error",result.extend.msg);
						$("#btn_save_emp").attr("valite","error");
					}
				}
			})
		})
		
		//1、我们是按钮创建之前就绑定了click，所以绑定不上。
		//1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
		//jquery新版没有live，使用on进行替代
		$(document).on("click",".btn_update",function(){
			reset_form("#empUpdateModal form");
			
			//根据id查询员工信息
			getEmp($(this).attr("id"));
				
			 //发送ajax请求，查出部门信息，显示在下拉列表
			getDpets("#dept_update_select");
			 //吧员工的id传递过去
			$("#btn_update_emp").attr("empId",$(this).attr("id"));
			$("#empUpdateModal").modal({
				backdrop:"true"
			});
		});
		
		//单个删除
		$(document).on("click",".btn_delete",function(){
			var empName=$(this).parents("tr").find("td:eq(2)").text();
			if(confirm("Delete sure?The "+empName)){
				$.ajax({
					url:"${path}/emp/"+$(this).attr("empId"),
					type:"DELETE",
					success:function(result){
						to_page(currentPage);
					}
				});
			}		
		});
		function getEmp(id){
			$.ajax({
				url:"${path}/emp/"+id,
				type:"GET",
				success:function(result){
					if(result.code==100){
						var emp=result.extend.emp;
						$("#input_update_name").val(emp.empName);
						$("#input_update_email").val(emp.email);
						$("#empUpdateModal input[name=gender]").val([emp.gender]);
						$("#empUpdateModal select").val([emp.dId]);
					}
				}
			})
		}
		
		//点击更新员工信息
		$("#btn_update_emp").click(function(){
			//验证邮箱是否合法
			var email=$("#input_update_email").val();
			var regEmail= /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				show_validate_msg("#input_update_email","error","邮箱格式错误");
				return false;
			}else{
				show_validate_msg("#input_update_email","success","");
			}
			
			//发送请求更新员工
			$.ajax({
				url:"${path}/emp/"+$(this).attr("empId"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize()+"",
				success:function(result){
					if(result.code==100){
						$("#empUpdateModal").modal('hide');
						to_page(currentPage);
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
						url:"${path}/emp/"+ids,
						type:"DELETE",
						success:function(result){
							to_page(currentPage);
						}
					})
				}
			}
		});
		
	</script>

</body>
</html>