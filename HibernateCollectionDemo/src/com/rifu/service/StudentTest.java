package com.rifu.service;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model.*;
import com.rifu.util.HibernateUtil;

/**
 * 测试hibernate中的集合框架类
 * 
 * 1，Set 无序 元素不可重复
	2，List 有序 元素可重复
	3，Bag 无序 元素可重复
	4，Map 键值对
 * @author Lifu
 *
 */

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

	/**
	 * 保存集合数据
	 */
	@Test
	public void testSaveSet() {
		Set<String> subjects=new HashSet<>();
		subjects.add("subject1");
		subjects.add("subject2");
		subjects.add("subject3");
		
		Student s=new Student();
		s.setSubjects(subjects);
		session.save(s);
	}
	
	/**
	 * 获取集合数据
	 */
	@Test
	public void testFetchSet() {
		Student student=(Student) session.get(Student.class, Long.valueOf(7));
		Iterator<String> iterator = student.getSubjects().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	/**
	 * 保存集合数据
	 */
	@Test
	public void testSaveList() {
		List<String> subjects=new ArrayList<>();
		subjects.add("subject1");
		subjects.add("subject2");
		subjects.add("subject3");
		
		Student2 s=new Student2();
		s.setSubjects(subjects);
		session.save(s);
	}
	
	/**
	 * 获取集合数据
	 */
	@Test
	public void testFetchList() {
		Student2 student=(Student2) session.get(Student2.class, Long.valueOf(8));
		Iterator<String> iterator = student.getSubjects().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	
	/**
	 * 保存集合数据
	 */
	@Test
	public void testSaveBag() {
		List<String> subjects=new ArrayList<>();
		subjects.add("subject1");
		subjects.add("subject2");
		subjects.add("subject3");
		
		Student3 s=new Student3();
		s.setSubjects(subjects);
		session.save(s);
	}
	
	/**
	 * 获取集合数据
	 */
	@Test
	public void testFetchBag() {
		Student3 student=(Student3) session.get(Student3.class, Long.valueOf(9));
		Iterator<String> iterator = student.getSubjects().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	/**
	 * 保存集合数据
	 */
	@Test
	public void testSaveMap() {
		Map<String,String> subjects=new HashMap<>();
		subjects.put("1","subject1");
		subjects.put("2","subject2");
		subjects.put("3","subject3");
		
		Student4 s=new Student4();
		s.setSubjects(subjects);
		session.save(s);
	}
	
	/**
	 * 获取集合数据
	 */
	@Test
	public void testFetchMap() {
		Student4 student=(Student4) session.get(Student4.class, Long.valueOf(10));
		Iterator<String> iterator = student.getSubjects().keySet().iterator();
		while(iterator.hasNext()){
			String key=iterator.next();
			System.out.println(key+":"+student.getSubjects().get(key));
		}
	}
}
