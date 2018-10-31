package com.rifu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rifu.bean.Employee;
import com.rifu.bean.EmployeeExample;
import com.rifu.bean.EmployeeExample.Criteria;
import com.rifu.dao.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Employee> getAllEmployees(){
		return employeeMapper.selectByExampleWithDept(null);
	}
	
	public int addEmployee(Employee e){
		return employeeMapper.insertSelective(e);
	}
	
	public boolean checkEmployee(String name){
		EmployeeExample example=new EmployeeExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmpNameEqualTo(name);
		long count = employeeMapper.countByExample(example);
		return count==0;
	}

	public Employee getEmployee(Integer empId) {
		Employee employee = employeeMapper.selectByPrimaryKey(empId);
		return employee;
	}

	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
		return true;
	}

	public int deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		return employeeMapper.deleteByPrimaryKey(empId);
	}

	public void deleteEmployeeBatch(List<Integer> empIds) {
		// TODO Auto-generated method stub
		EmployeeExample example=new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(empIds);
		employeeMapper.deleteByExample(example);
	}
}
