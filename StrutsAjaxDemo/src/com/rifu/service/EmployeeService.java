package com.rifu.service;

import com.rifu.dao.EmployeeDao;
import com.rifu.entity.Employee;
import com.rifu.entity.Msg;
import com.rifu.entity.PageInfo;

public class EmployeeService {
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Msg getEmps(int pageSize,int pagenum){
		PageInfo<Employee> pageInfo = employeeDao.getEmps(pagenum,pageSize);
		System.out.println("pageinfo:"+pageInfo);
		return  Msg.success().add("pageInfo", pageInfo);
	}
	
	public Msg getEmp(int id){
		Employee emp = employeeDao.getEmp(id);
		return Msg.success().add("emp", emp);
	}
	
	public Msg save(Employee e){
		System.out.println("service:"+e);
		employeeDao.save(e);
		return Msg.success();
	}
	
	public Msg delete(Integer id){
		employeeDao.delete(id);
		return Msg.success();
	}
	
	public Msg deleteByIds(String ids){
		employeeDao.deleteByIds(ids);
		return Msg.success();
	}
}
