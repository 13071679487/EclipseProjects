package com.rifu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rifu.entity.Employee;

public class BaseDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.openSession();
	}
	
	public void closeSession(){
//		if(this.sessionFactory.getCurrentSession().isOpen())
//			this.sessionFactory.close();
	}
}
