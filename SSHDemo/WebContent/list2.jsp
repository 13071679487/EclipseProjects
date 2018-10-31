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
							<th>birth_day</th>
							<th>create_time</th>
							<th>Department</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${emps }" var="emp">
						<tr>
						<td><input type="checkbox" name="select"></td>
							<td>${emp.emp_id }</td>
							<td>${emp.emp_name }</td>
							<td>${emp.email }</td>
							<td>${emp.birth_day }</td>
							<td>${emp.create_time }</td>
							<td>${emp.dept.dept_name }</td>
							<td>
								<button type="button" class="btn btn-primary btn-xs" id="btn_addEmp" >编辑</button>&nbsp;
								<button type="button" class="btn btn-danger btn-xs" id="btn_deleteEmp">删除</button>
							</td>
						</tr>
					</c:forEach>
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
			
		}
		
		//解析显示分页信息
		function build_page_info(result){
			
		}
		
		//解析显示分页条
		function build_page_nav(result){
			
		}
		
		$("#btn_addEmp").click(function(){
			 $("#empAddModal").modal({
				 backgrop:'true'
			 });
		}); 
		
		function to_page(pageNum){
			/*
			 $.ajax({
				url:"emp-list",
				data:"pn="+(pageNum-1),
				type:"POST",
				success:function(result){
					$.each(${emps},function(index,item){
						var checkboxTd=$("<td><input type='checkbox' class='check_item'/></td>");
						var empIdTd=$("<td></td>").append(item.emp_id);
						var empNameTd=$("<td></td>").append(item.emp_ame);
						var empEmailTd=$("<td></td>").append(item.email);
						var empBirthdayTd=$("<td></td>").append(item.birth_day);
						var empCreateTimeTd=$("<td></td>").append(item.create_time);
						var empDeptTd=$("<td></td>").append(item.dept.dept_name);
						
						var btnEdit=$("<button></button>").addClass("btn btn-warning btn-sm btn_update")
							.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
						btnEdit.attr("id",item.empId);
						//$(btnEdit).click=edit_emp(item);
						var btnDelete=$("<button></button>").addClass("btn btn-danger btn-sm btn_delete")
							.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
						btnDelete.attr("empId",item.empId);
						var btnTd=$("<td></td>").append(btnEdit).append("&nbsp;").append(btnDelete);
						
						$("<tr></tr>")
						.append(checkboxTd)
						.append(empIdTd)
						.append(empNameTd)
						.append(empEmailTd)
						.append(empBirthdayTd)
						.append(empCreateTimeTd)
						.append(empDeptTd)
						.append(btnTd)
						.appendTo("#emps_table tbody");
					});
				}
			});
			*/
		}
		//查出部门信息，显示在下拉列表
		function getDpets(ele){
			
		}
		
		function reset_form(ele){
			
		}
		/*
			点击保存的点击事件
		*/
		$("#btn_save_emp").click(function(){
			
		})
		//检验姓名和邮箱字段
		function validate_add_emp(){
			
		}
		
		/*
			显示检验信息
		*/
		function show_validate_msg(ele,status,msg){
			
		}
		
		/*
			当姓名输入框发生改变，发送请求检验姓名是否可用
		*/
		$("#input_name").change(function(){
			
		})
		
		//1、我们是按钮创建之前就绑定了click，所以绑定不上。
		//1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
		//jquery新版没有live，使用on进行替代
		$(document).on("click",".btn_update",function(){
			
			
		});
		
		//单个删除
		$(document).on("click",".btn_delete",function(){
			
			
		});
		function getEmp(id){
			
		}
		
		//点击更新员工信息
		$("#btn_update_emp").click(function(){
			
		});
		
		$("#check_all").click(function(){
			
		});
		
		//当所有checkbox都选了，就应该给check_all也给选上
		$(document).on("click",".check_item",function(){
			
		});
		
		$("#btn_deleteEmp").click(function(){
			
		});
		
	</script>

</body>
</html>