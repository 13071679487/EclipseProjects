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
/**
 * ��������ļ���ɾ��������˵��ļ�����ɾ�����ڵ�֮ǰ��Ҫɾ���ӽڵ㣩
 * @author Lifu
 *
 */
public class NodeTest {
	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	private Session session;
	@Before
	public void setUp() throws Exception {
		session=sessionFactory.openSession(); // ����һ��session
	    session.beginTransaction(); // ��������
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit(); // �ύ����
		 session.close(); // �ر�session
	}

	@Test
	public void testSaveNode() {
		Node parentNode=new Node();
		parentNode.setName("���Ǹ��ڵ�");
		
		Node subNode1=new Node();
		subNode1.setName("�����ӽڵ�1");
		
		Node subNode2=new Node();
		subNode2.setName("�����ӽڵ�1");
		
		subNode1.setParentNode(parentNode);
		subNode2.setParentNode(parentNode);
		
		session.save(subNode1);
		session.save(subNode2);
	}
}
