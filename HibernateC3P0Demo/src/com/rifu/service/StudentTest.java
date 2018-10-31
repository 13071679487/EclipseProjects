package com.rifu.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model.Student;
import com.rifu.util.HibernateUtil;

public class StudentTest {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private static Session session;
	
	private Logger logger=Logger.getLogger(StudentTest.class);

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void createTable() {
	}
	
	@Test 
	public void testQuery(){
		String sql = "select * from t_student";
		Query query = session.createSQLQuery(sql).addEntity(Student.class);
		List studentList = query.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
		logger.debug("这是一个debug信息");
		logger.info("这是一个info信息");
		logger.error("这是一个错误信息");
	}

}
