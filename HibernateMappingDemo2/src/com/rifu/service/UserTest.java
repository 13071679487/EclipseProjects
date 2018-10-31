package com.rifu.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model.Address;
import com.rifu.model.Address2;
import com.rifu.model.User;
import com.rifu.model.User2;
import com.rifu.util.HibernateUtil;

public class UserTest {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession(); // ����һ��session
		session.beginTransaction(); // ��������
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit(); // �ύ����
		session.close(); // �ر�session
	}

	/**
	 * ��������Լ�������忴���ñ�
	 * @throws Exception
	 */
	@Test
	public void testSave1() throws Exception {
		User user=new User();
		user.setUserName("rifu");
		
		Address address=new Address();
		address.setAddressName("address1");
		address.setCode("525139");
		address.setUser(user);
		user.setAddress(address);
		session.save(user);
	}
	
	/**
	 * �������Լ�������忴���ñ�
	 * @throws Exception
	 */
	@Test
	public void testSave2() throws Exception {
		User2 user=new User2();
		user.setUserName("rifu");
		
		Address2 address=new Address2();
		address.setAddressName("address1");
		address.setCode("525139");
		address.setUser(user);
		user.setAddress(address);
		session.save(user);
	}
	


}
