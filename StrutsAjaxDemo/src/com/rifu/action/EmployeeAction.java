package com.rifu.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.rifu.entity.Employee;
import com.rifu.service.EmployeeService;

import net.sf.json.JSONObject;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> ,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee model=new Employee();
	private String jsonData;
	EmployeeService employeeService = (EmployeeService) new ClassPathXmlApplicationContext(
			"applicationContext.xml").getBean("employeeService");

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public String list() throws Exception {
		int pageNum=Integer.parseInt(ServletActionContext.getRequest().getParameter("pn"));
		if (employeeService != null) {
			jsonData = JSONObject.fromObject(employeeService.getEmps(8, pageNum)).toString();
		} else {
			System.out.println("service为null");
		}
		return "list";
	}

	public String get() throws Exception {
		int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		jsonData = JSONObject.fromObject(employeeService.getEmp(id)).toString();
		return "get";
	}

	public String save() throws Exception {
		System.out.println(model);
		jsonData = JSONObject.fromObject(employeeService.save(model)).toString();
		return "save";
	}

	public String update() throws Exception {
		System.out.println(model);
		jsonData = JSONObject.fromObject(employeeService.save(model)).toString();
		return "update";
	}

	public String delete() throws Exception {
		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		System.out.println("要删除的id是:"+id);
		jsonData = JSONObject.fromObject(employeeService.delete(id)).toString();
		return "delete";
	}
	
	public String deleteByIds()throws Exception{
		String ids=ServletActionContext.getRequest().getParameter("ids");
		if(ids.contains("-")){
			ids=ids.replace("-", ",");
		}
		jsonData=JSONObject.fromObject(employeeService.deleteByIds(ids)).toString();
		return "deleteByIds";
	}

	@Override
	public void prepare() throws Exception {	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return model;
	}


}
