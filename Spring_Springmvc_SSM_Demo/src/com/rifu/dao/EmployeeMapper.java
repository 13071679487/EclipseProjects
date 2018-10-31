package com.rifu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rifu.bean.Employee;

@Repository
public interface EmployeeMapper {
	public Employee getEmployeeById(Integer id);

	public List<Employee> getEmps();
}
