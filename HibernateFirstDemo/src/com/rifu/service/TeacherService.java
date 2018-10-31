package com.rifu.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rifu.model.Teacher;
import com.rifu.util.HibernateUtil;

public class TeacherService {
	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	public void add(Teacher teacher){
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		session.save(teacher);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}
	
	public void delete(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		Teacher teacher=(Teacher)session.get(Teacher.class,Long.valueOf(1));
		session.delete(teacher);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}
	
	public void update(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		Teacher teacher=(Teacher) session.get(Teacher.class, Long.valueOf(1));
		teacher.setName("22");
		session.save(teacher);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}
	
	public void getAllTeacher(){
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
	public static void main(String[] args) {
		TeacherService teacherService=new TeacherService();
		teacherService.add(new Teacher("rifu"));
		teacherService.getAllTeacher();
	}
	
}
