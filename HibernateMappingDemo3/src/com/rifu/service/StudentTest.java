package com.rifu.service;


import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model.Course;
import com.rifu.model.Student;
import com.rifu.util.HibernateUtil;

public class StudentTest {
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
		Course course=new Course();
		course.setCourseName("语文");
		
		Course course1=new Course();
		course1.setCourseName("数学");
		
		Student student=new Student();
		student.setStuName("rifu");
		student.getCourses().add(course);
		student.getCourses().add(course1);
		
		Student student1=new Student();
		student1.setStuName("lifu");
		student1.getCourses().add(course);
		student1.getCourses().add(course1);
		
		session.save(student);
		session.save(student1);
	}
	
	@Test
	public void testLoad1(){
		Student student = (Student) session.get(Student.class, Long.valueOf(1));
		Set<Course> courses = student.getCourses();
		Iterator<Course> it = courses.iterator();
		while(it.hasNext()){
			Course course = (Course)it.next();
			System.out.println(course.getCourseName());
		}
	}

}
