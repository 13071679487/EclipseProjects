package com.rifu.service;

import com.rifu.model.*;
import com.rifu.model.Class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.util.HibernateUtil;

public class StudentTest {
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
	public void testSaveClassAndStudent() {
		Class c=new Class("15�ƿ�");
	    session.save(c);
	    
	    Student s1=new Student();
	    s1.setName("����");
	    s1.setC(c);
	    
	    Student s2=new Student();
	    s2.setName("����");
	    s2.setC(c);
	    
	    session.save(s1);
	    session.save(s2);
	}
	
	@Test
	public void testSaveClassAndStudentWithCascade() {
		Class c=new Class("15�ƿ�");
	    //������û�н��б��棬�ں������ѧ����Ϣ���棬ʹ�ü������棬���ñ��ڸ�Ŀ¼�µ�student.hmb.xml
	    
	    Student s1=new Student();
	    s1.setName("����");
	    s1.setC(c);
	    
	    Student s2=new Student();
	    s2.setName("����");
	    s2.setC(c);
	    
	    session.save(s1);
	    session.save(s2);
	}

}