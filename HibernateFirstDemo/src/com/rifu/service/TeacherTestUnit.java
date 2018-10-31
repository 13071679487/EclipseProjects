package com.rifu.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.rifu.model.Teacher;
import com.rifu.util.HibernateUtil;
/**
 * ��Ԫ������
 * @author Lifu
 *
 */
public class TeacherTestUnit {
	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

	@Test
	public void testAdd() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		Teacher teacher =new Teacher("rifu3");
		session.save(teacher);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}

	@Test
	public void testDelete() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		Teacher teacher=(Teacher)session.get(Teacher.class,Long.valueOf(1));
		session.delete(teacher);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}

	@Test
	public void testUpdate() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		Teacher teacher=(Teacher) session.get(Teacher.class, Long.valueOf(1));
		teacher.setName("22");
		session.save(teacher);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}

	@Test
	public void testGetAllTeacher() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		String hql="from Teacher";
		Query query=session.createQuery(hql);
		List<Teacher> teacherList=query.list();
		for(int i=0;i<teacherList.size();i++){
			System.out.println(teacherList.get(i));
		}
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}

}
