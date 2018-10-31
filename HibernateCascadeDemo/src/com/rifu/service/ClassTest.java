package com.rifu.service;

import com.rifu.model.*;
import com.rifu.model.Class;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.util.HibernateUtil;

public class ClassTest {
	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	private Session session;
	@Before
	public void setUp() throws Exception {
		session=sessionFactory.openSession(); // 生成一个session
	    session.beginTransaction(); // 开启事务
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit(); // 提交事务
		 session.close(); // 关闭session
	}

	@Test
	public void testSaveClassAndStudent() {
		Class c=new Class("15计科");
	    
	    Student s1=new Student("张三");
	    //在这里没有进行学生信息的保存（为临时对象，进行save操作后为持久化对象）
	    
	    Student s2=new Student("李四");
	    
	    c.getStudents().add(s1);
	    c.getStudents().add(s2);
	    
	    //在这里进行班级的保存，里面级联的学生信息也会进行保存，在class.hmb.xml配置表设置为级联为“save-update”
	    session.save(c);
	}
	@Test
	public void getStudentByClass(){
		Class c=(Class)session.get(Class.class, Long.valueOf(1));
		Set<Student> students=c.getStudents();
		Iterator i=students.iterator();
		while(i.hasNext()){
			Student s=(Student) i.next();
			System.out.println(s);
		}
	}
	
	/**
	 * 测试inverse属性，
	 */
	@Test
	public void testInverse(){
		Class c=(Class)session.get(Class.class, Long.valueOf(1));
		Student s=new Student("lifu");
		
		s.setC(c);
		c.getStudents().add(s);
	}
}
