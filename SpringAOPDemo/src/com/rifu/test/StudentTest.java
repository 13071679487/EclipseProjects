package com.rifu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rifu.service.StudentService;

public class StudentTest {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		StudentService studentService=(StudentService)ac.getBean("studentService");
		studentService.addStudent("уехЩ");
	}
}
