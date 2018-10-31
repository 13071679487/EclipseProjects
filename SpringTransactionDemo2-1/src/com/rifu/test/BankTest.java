package com.rifu.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rifu.service.BankService;


public class BankTest {
	private ApplicationContext ac;
	
	@Before
	public void setUp() throws Exception{
		ac = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	public void treasferAccount(){
		BankService bs=(BankService)ac.getBean("bankService");
		bs.transferAccount(50, 1,2);
	}
	
}
