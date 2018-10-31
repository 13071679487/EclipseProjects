package com.rifu.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model.Student;
import com.rifu.util.HibernateUtil;

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
	 * 
	 * load()方法 VS get()方法 都是根据 OID 从数据库中加载一个持久化对象。 区别 1：假如数据库中不存在与 OID
	 * 对应的记录，Load()方法会抛出异常，而 get()方法返回 null; 区别 2：load 方法默认采用延迟加载策略，get
	 * 方法采用立即检索策略；
	 */
	@Test
	public void testLoad() {
		Student s = (Student) session.load(Student.class, Long.valueOf(3));
		System.out.println(s);
	}

	@Test
	public void testGet() {
		Student s = (Student) session.get(Student.class, Long.valueOf(3));
		System.out.println(s);
	}

	@Test
	public void testUpdate() {
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Student student = (Student) session1.get(Student.class, Long.valueOf(1));
		session1.getTransaction().commit(); // 提交事务
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.update(student);
		session2.getTransaction().commit(); // 提交事务
		session2.close();
	}

	/**
	 * saveOrUpdate()方法 包含了 save()和 update()方法；
	 */
	@Test
	public void testSaveOrUpdate() {
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		Student c=(Student)session1.get(Student.class, Long.valueOf(1));
		session1.getTransaction().commit(); // 提交事务
		session1.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		c.setName("08计算机本科3");
		
		Student c2=new Student();
		c2.setName("09计算机本科3");
		session2.saveOrUpdate(c);
		session2.saveOrUpdate(c2);
		session2.getTransaction().commit(); // 提交事务
		session2.close();
	}
	/**
	 * merge存在要解决的问题是，当你想要update一个对象，而此时在session的缓存中存在着一个OID(对象id)相同的对象，就会抛出异常
	 */
	@Test
	public void testMerge() {
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		Student c=(Student)session1.get(Student.class, Long.valueOf(1));
		session1.getTransaction().commit(); // 提交事务
		session1.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		
		Student c2=(Student)session2.get(Student.class, Long.valueOf(1));
		c.setName("08计算机本科4");
	
		session2.merge(c);

		session2.getTransaction().commit(); // 提交事务
		session2.close();
	}

	@Test
	public void testDelete() {
		Student student=(Student)session.load(Student.class, Long.valueOf(1));
		session.delete(student);
	}

}
