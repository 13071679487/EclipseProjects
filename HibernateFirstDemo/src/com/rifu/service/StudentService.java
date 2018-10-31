package com.rifu.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rifu.model.Student;
import com.rifu.util.HibernateUtil;

public class StudentService {
	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	private void add(Student student){
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		session.save(student);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}
	
	private void delete(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		Student student=(Student)session.get(Student.class,Long.valueOf(1));
		session.delete(student);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}
	
	private void update(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		Student student=(Student) session.get(Student.class, Long.valueOf(1));
		student.setName("22");
		session.save(student);
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}
	
	private void getAllStudent(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();	//��������
		
		String hql="from Student";
		Query query=session.createQuery(hql);
		List<Student> studentList=query.list();
		for(int i=0;i<studentList.size();i++){
			System.out.println(studentList.get(i));
		}
		
		session.getTransaction().commit();//�ύ����
		session.close();	//	�ر�Session
	}
	public static void main(String[] args) {
		StudentService studentService=new StudentService();
		studentService.add(new Student("rifu"));
		studentService.getAllStudent();
	}
	
}
