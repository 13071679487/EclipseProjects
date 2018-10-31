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
		session = sessionFactory.openSession(); // ����һ��session
		session.beginTransaction(); // ��������
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit(); // �ύ����
		session.close(); // �ر�session
	}

	/**
	 * 
	 * load()���� VS get()���� ���Ǹ��� OID �����ݿ��м���һ���־û����� ���� 1���������ݿ��в������� OID
	 * ��Ӧ�ļ�¼��Load()�������׳��쳣���� get()�������� null; ���� 2��load ����Ĭ�ϲ����ӳټ��ز��ԣ�get
	 * �������������������ԣ�
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
		session1.getTransaction().commit(); // �ύ����
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.update(student);
		session2.getTransaction().commit(); // �ύ����
		session2.close();
	}

	/**
	 * saveOrUpdate()���� ������ save()�� update()������
	 */
	@Test
	public void testSaveOrUpdate() {
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		Student c=(Student)session1.get(Student.class, Long.valueOf(1));
		session1.getTransaction().commit(); // �ύ����
		session1.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		c.setName("08���������3");
		
		Student c2=new Student();
		c2.setName("09���������3");
		session2.saveOrUpdate(c);
		session2.saveOrUpdate(c2);
		session2.getTransaction().commit(); // �ύ����
		session2.close();
	}
	/**
	 * merge����Ҫ����������ǣ�������Ҫupdateһ�����󣬶���ʱ��session�Ļ����д�����һ��OID(����id)��ͬ�Ķ��󣬾ͻ��׳��쳣
	 */
	@Test
	public void testMerge() {
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		Student c=(Student)session1.get(Student.class, Long.valueOf(1));
		session1.getTransaction().commit(); // �ύ����
		session1.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		
		Student c2=(Student)session2.get(Student.class, Long.valueOf(1));
		c.setName("08���������4");
	
		session2.merge(c);

		session2.getTransaction().commit(); // �ύ����
		session2.close();
	}

	@Test
	public void testDelete() {
		Student student=(Student)session.load(Student.class, Long.valueOf(1));
		session.delete(student);
	}

}
