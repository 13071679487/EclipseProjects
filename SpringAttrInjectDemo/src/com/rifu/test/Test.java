package com.rifu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rifu.model.User;


public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		User user=(User) ac.getBean("user");
		System.out.println(user);
		
		//属性注入
		User user1=(User) ac.getBean("user1");
		System.out.println(user1);
		
		//
		User user2=(User) ac.getBean("user2");
		System.out.println(user2);
		
		//索引注入
		User user3=(User) ac.getBean("user3");
		System.out.println(user3);
		
		
		User user4=(User) ac.getBean("user4");
		System.out.println(user4);
		
		
		//工厂方法注入
		User user5=(User) ac.getBean("user5");
		System.out.println(user5);
		
		
		//工厂静态方法注入
		User user6=(User) ac.getBean("user6");
		System.out.println(user6);
		
	}
}
