//package com.mvc.app.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.mvc.app.dao.IStudentDao;
//import com.mvc.app.model.Student1;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:META-INF/spring/spring-context.xml"})
//public class StudentDaoTest {
//	
//	@Autowired
//	private IStudentDao studentDao;
//	
//	@Test
//	public void findByName(){
//		Student1 student=studentDao.findByName("王亮");
//		System.out.println(student);
//	}
//	
//	@Test
//	public void findById(){
//		Student1 student=studentDao.findById("AP0803704");
//		System.out.println(student.getSname());
//	}
//	@Test
//	public void update(){
//	   Student1 student=studentDao.findById("AP0803704");
//	   student.setSname("五邑");
//	   studentDao.update(student);
//	   
//	}
//	@Test
//	public void deleteById(){
//		studentDao.deleteById("123");
//	}
//}
