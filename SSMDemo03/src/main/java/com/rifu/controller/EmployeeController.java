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
 * ����Ա����CRUD����
 * 
 * @author Lifu
 *
 */
@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	/**
	 * ��ѯ����Ա������ҳ��ѯ��
	 * 
	 * @return
	 */
	// @RequestMapping("/emps")
	public String getEmployees(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum, Model model) {

		// ʹ�÷�ҳ���
		PageHelper.startPage(pageNum, 8);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> employees = employeeService.getAllEmployees();
		// PageInfo �����˷ǳ�ȫ��ķ�ҳ���ԣ�ҳ�룬size,�Ƿ�����һҳ�ȵȣ������佻��ҳ��Ϳ�����
		// �ڶ����������Ա�ʾ������ʾ��ҳ��
		PageInfo pageInfo = new PageInfo(employees, 3);
		model.addAttribute("pageInfo", pageInfo);
		return "list";
	}

	/**
	 * ����pageInfo�����溬��������Ϣ������������ƽ̨ Ҫʹ@ResponseBody������������Ҫ����jackjson
	 * 
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmployeesAsJSON(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum) {
		// ʹ�÷�ҳ���
		PageHelper.startPage(pageNum, 8);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> employees = employeeService.getAllEmployees();
		// PageInfo �����˷ǳ�ȫ��ķ�ҳ���ԣ�ҳ�룬size,�Ƿ�����һҳ�ȵȣ������佻��ҳ��Ϳ�����
		// �ڶ����������Ա�ʾ������ʾ��ҳ��
		PageInfo pageInfo = new PageInfo(employees, 5);

		return Msg.success().add("pageInfo", pageInfo);
	}

	/**
	 * ͨ������ʽ�Ĳ�ͬ��������������ĸ�����
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
	 * ͨ������ʽ�Ĳ�ͬ��������������ĸ�����
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
	 * ���ֱ�ӷ���ajax=PUT��ʽ������
	 * ��װ������
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * ���⣺
	 * �������������ݣ�
	 * ����Employee�����װ���ϣ�
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * ԭ��
	 * Tomcat��
	 * 		1�����������е����ݣ���װһ��map��
	 * 		2��request.getParameter("empName")�ͻ�����map��ȡֵ��
	 * 		3��SpringMVC��װPOJO�����ʱ��
	 * 				���POJO��ÿ�����Ե�ֵ��request.getParamter("email");
	 * AJAX����PUT����������Ѫ����
	 * 		PUT�����������е����ݣ�request.getParameter("empName")�ò���
	 * 		Tomcatһ����PUT�����װ�������е�����Ϊmap��ֻ��POST��ʽ������ŷ�װ������Ϊmap
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * ���������
	 * ����Ҫ��֧��ֱ�ӷ���PUT֮�������Ҫ��װ�������е�����
	 * 1����web.xml������HttpPutFormContentFilter��
	 * 2���������ã����������е����ݽ���  ��װ��һ��map��
	 * 3��request�����°�װ��request.getParameter()����д���ͻ���Լ���װ��map��ȡ����
	 * Ա�����·���
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
	 * ����ɾ��
	 * @param ids  Ҫɾ����id���м���-�ָ�
	 * @return
	 */
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteEmployeeByIds(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			//����ɾ��
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
	 * �����û����Ƿ����
	 * @return
	 */
	@RequestMapping("/checkemp")
	@ResponseBody
	public Msg checkEmployee(@RequestParam("empName")String empName){
		//���ж��û����Ƿ�Ϸ�
		String regex="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(regex)){
			return Msg.fail().add("msg", "��ʽΪ6~16λ��ĸ�����֣�����2~5λ����");
		}
		boolean result = employeeService.checkEmployee(empName);
		if(result){
			return Msg.success();
		}else{
			return Msg.fail().add("msg", "�û���������");
		}
	}
}
