package com.rifu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rifu.model.Bottle;

public class BottleTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Bottle bean = (Bottle)ac.getBean("bottle");
		bean.beginDrink();
	}
}
