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

public class ClassTest {
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
	    
	    Student s1=new Student("����");
	    //������û�н���ѧ����Ϣ�ı��棨Ϊ��ʱ���󣬽���save������Ϊ�־û�����
	    
	    Student s2=new Student("����");
	    
	    c.getStudents().add(s1);
	    c.getStudents().add(s2);
	    
	    //��������а༶�ı��棬���漶����ѧ����ϢҲ����б��棬��class.hmb.xml���ñ�����Ϊ����Ϊ��save-update��
	    session.save(c);
	}
	@Test
	public void getStudentByClass(){
		Class c=(Class)session.get(Class.class, Long.valueOf(1));
		Set<Student> students=c.getStudents();
		Iterator i=students.iterator();
		while(i.hasNext()){
			Student s=(Student) i.next();
			System.out.println(s);
		}
	}
	
	/**
	 * ����inverse���ԣ�
	 */
	@Test
	public void testInverse(){
		Class c=(Class)session.get(Class.class, Long.valueOf(1));
		Student s=new Student("lifu");
		
		s.setC(c);
		c.getStudents().add(s);
	}
}
