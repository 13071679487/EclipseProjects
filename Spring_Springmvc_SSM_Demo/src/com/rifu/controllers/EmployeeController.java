package com.rifu.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rifu.bean.Employee;
import com.rifu.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("emps")
	public String getEmps(Map<String,Object> map){
		List<Employee> emps = employeeService.getEmps();
		map.put("emps",emps);
		return "list";
	}
}
