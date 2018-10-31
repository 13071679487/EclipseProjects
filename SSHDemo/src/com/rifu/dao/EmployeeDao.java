package com.rifu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rifu.entities.Employee;

public class EmployeeDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.openSession();
	}
	
	public List<Employee> getEmps(int pageNum){
		int start=pageNum*8;
		String hql="FROM Employee";
		Query query=getSession().createQuery(hql);
		List<Employee> emps=query.list();
		System.out.println(emps.size());
		return emps;
	}
}
