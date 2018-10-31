package com.rifu.service;

import java.util.List;

import com.rifu.dao.EmployeeDao;
import com.rifu.entities.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public List<Employee> getEmps(int pageNum){
		return employeeDao.getEmps(pageNum);
	}
}
