package com.rifu.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rifu.model.User;

public class UserTest {
	private ApplicationContext ac;

	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("beans.xml");
	}

	/**
	 *��������ֵע�� 
	 */
	@Test
	public void test1() {
		User user=(User) ac.getBean("user1");
		System.out.println(user);
	}
	
	/**
	 *beanע�� 
	 */
	@Test
	public void test2() {
		User user=(User) ac.getBean("user2");
		System.out.println(user);
	}
	
	/**
	 *�ڲ�bean 
	 */
	@Test
	public void test3() {
		User user=(User) ac.getBean("user3");
		System.out.println(user);
	}
	
	/**
	 *ע��Null 
	 */
	@Test
	public void test4() {
		User user=(User) ac.getBean("user4");
		System.out.println(user);
	}
	
	/**
	 *����ע�� 
	 */
	@Test
	public void test5() {
		User user=(User) ac.getBean("user5");
		System.out.println(user);
	}

}
