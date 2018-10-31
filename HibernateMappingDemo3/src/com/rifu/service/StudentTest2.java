package com.rifu.service;


import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model2.*;
import com.rifu.util.HibernateUtil;

public class StudentTest2 {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession(); // 生成一个session
		session.beginTransaction(); // 开启事务
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit(); // 提交事务
		session.close(); // 关闭session
	}
	@Test
	public void testSave1(){
		Course2 course=new Course2();
		course.setCourseName("语文1");
		
		Course2 course1=new Course2();
		course1.setCourseName("数学1");
		
		Student2 student=new Student2();
		student.setStuName("rifu1");
		student.getCourses().add(course);
		student.getCourses().add(course1);
		
		Student2 student1=new Student2();
		student1.setStuName("lifu1");
		student1.getCourses().add(course);
		student1.getCourses().add(course1);
		
		session.save(student);
		session.save(student1);
	}
	
	@Test
	public void testLoad1(){
		Course2 course = (Course2) session.get(Course2.class, Long.valueOf(1));
		Iterator<Student2> it = course.getStudents().iterator();
		while(it.hasNext()){
			Student2 student =(Student2) it.next();
			System.out.println(student.getStuName());
		}
	}

}
