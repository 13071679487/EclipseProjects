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
 * 测试自身的级联删除（例如菜单的级联，删除根节点之前先要删除子节点）
 * @author Lifu
 *
 */
public class NodeTest {
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
	public void testSaveNode() {
		Node parentNode=new Node();
		parentNode.setName("我是根节点");
		
		Node subNode1=new Node();
		subNode1.setName("我是子节点1");
		
		Node subNode2=new Node();
		subNode2.setName("我是子节点1");
		
		subNode1.setParentNode(parentNode);
		subNode2.setParentNode(parentNode);
		
		session.save(subNode1);
		session.save(subNode2);
	}
}
