package com.rifu.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rifu.model.Student;
import com.rifu.service.StudentService;


public class StudentTest {
	private ApplicationContext ac;
	
	@Before
	public void setUp() throws Exception{
		ac = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	public void addStudent(){
		StudentService studentService=(StudentService)ac.getBean("studentService");
		int updateNum=studentService.addStudent(new Student("rifu",12));
		if(updateNum==1){
			System.out.println("添加成功");
		}
	}
	
	@Test
	public void updateStudent(){
		StudentService studentService=(StudentService)ac.getBean("studentService");
		int updateNum=studentService.updateStudent(new Student(6,"rifu7",18));
		if(updateNum==1){
			System.out.println("更新成功");
		}
	}
	
	@Test
	public void deleteStudent(){
		StudentService studentService=(StudentService)ac.getBean("studentService");
		int updateNum=studentService.deleteStudent(6);
		if(updateNum==1){
			System.out.println("删除成功");
		}
	}
	
	@Test
	public void getAllStudent(){
		StudentService studentService=(StudentService)ac.getBean("studentService");
		List<Student> students=studentService.findStudents();
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
