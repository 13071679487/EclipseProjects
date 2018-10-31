package com.rifu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rifu.bean.Employee;
import com.rifu.bean.Msg;
import com.rifu.service.EmployeeService;

/**
 * 处理员工的CRUD请求
 * 
 * @author Lifu
 *
 */
@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	/**
	 * 查询所有员工（分页查询）
	 * 
	 * @return
	 */
	// @RequestMapping("/emps")
	public String getEmployees(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum, Model model) {

		// 使用分页插件
		PageHelper.startPage(pageNum, 8);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> employees = employeeService.getAllEmployees();
		// PageInfo 包含了非常全面的分页属性（页码，size,是否有下一页等等），将其交给页面就可以了
		// 第二个参数可以表示连续显示的页数
		PageInfo pageInfo = new PageInfo(employees, 3);
		model.addAttribute("pageInfo", pageInfo);
		return "list";
	}

	/**
	 * 返回pageInfo，里面含有所有信息，适用于所有平台 要使@ResponseBody正常工作，需要导入jackjson
	 * 
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmployeesAsJSON(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum) {
		// 使用分页插件
		PageHelper.startPage(pageNum, 8);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> employees = employeeService.getAllEmployees();
		// PageInfo 包含了非常全面的分页属性（页码，size,是否有下一页等等），将其交给页面就可以了
		// 第二个参数可以表示连续显示的页数
		PageInfo pageInfo = new PageInfo(employees, 5);

		return Msg.success().add("pageInfo", pageInfo);
	}

	/**
	 * 通过请求方式的不同来区分请求的是哪个方法
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public Msg addEmployee(@Valid Employee emp,BindingResult result) {
		if(result.hasErrors()){
			Map<String ,Object> map=new HashMap<String,Object>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			for(FieldError error:fieldErrors){
				System.out.println(error);
				map.put(error.getField(), error.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			int resultNum = employeeService.addEmployee(emp);
			return Msg.success();
		}
	}
	
	/**
	 * 通过请求方式的不同来区分请求的是哪个方法
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getEmployee(@PathVariable("id") Integer empId){
		Employee employee = employeeService.getEmployee(empId);
		System.out.println("GET"+employee);
		if(employee==null){
			return Msg.fail();
		}
		return Msg.success().add("emp", employee);
	}
	
	
	/**
	 * 如果直接发送ajax=PUT形式的请求
	 * 封装的数据
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * 问题：
	 * 请求体中有数据；
	 * 但是Employee对象封装不上；
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * 原因：
	 * Tomcat：
	 * 		1、将请求体中的数据，封装一个map。
	 * 		2、request.getParameter("empName")就会从这个map中取值。
	 * 		3、SpringMVC封装POJO对象的时候。
	 * 				会把POJO中每个属性的值，request.getParamter("email");
	 * AJAX发送PUT请求引发的血案：
	 * 		PUT请求，请求体中的数据，request.getParameter("empName")拿不到
	 * 		Tomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * 解决方案；
	 * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
	 * 1、在web.xml配置上HttpPutFormContentFilter；
	 * 2、他的作用；将请求体中的数据解析  包装成一个map。
	 * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
	 * 员工更新方法
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateEmployee(Employee employee){
		System.out.println("UPDATE:"+employee);
		employeeService.updateEmployee(employee);
		return Msg.success();
	}
	
//	@ResponseBody
//	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public Msg deleteEmployee(@PathVariable("id") Integer empId){
		System.out.println("empId:"+empId);
		int deleteNum = employeeService.deleteEmployee(empId);
		System.out.println("deleteNum:"+deleteNum);
		return Msg.success();
	}
	/**
	 * 批量删除
	 * @param ids  要删除的id，中间用-分割
	 * @return
	 */
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteEmployeeByIds(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			//批量删除
			List<Integer> empIds=new ArrayList<Integer>();
			String[] strs = ids.split("-");
			for(String str:strs){
				Integer id = Integer.parseInt(str);
				empIds.add(id);
			}
			employeeService.deleteEmployeeBatch(empIds);
			return Msg.success();
		}else{
			employeeService.deleteEmployee(Integer.parseInt(ids));
			return Msg.success();
		}
	}
	
	/**
	 * 检验用户名是否可用
	 * @return
	 */
	@RequestMapping("/checkemp")
	@ResponseBody
	public Msg checkEmployee(@RequestParam("empName")String empName){
		//先判断用户名是否合法
		String regex="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(regex)){
			return Msg.fail().add("msg", "格式为6~16位字母加数字，或者2~5位汉字");
		}
		boolean result = employeeService.checkEmployee(empName);
		if(result){
			return Msg.success();
		}else{
			return Msg.fail().add("msg", "用户名不可用");
		}
	}
}
