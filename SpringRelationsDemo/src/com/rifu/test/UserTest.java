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
	 *基本类型值注入 
	 */
	@Test
	public void test1() {
		User user=(User) ac.getBean("user1");
		System.out.println(user);
		User user2=(User) ac.getBean("user2");
		System.out.println(user2);
	}

}
