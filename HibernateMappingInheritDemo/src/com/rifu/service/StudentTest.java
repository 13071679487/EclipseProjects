package com.rifu.service;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model.*;
import com.rifu.model2.*;
import com.rifu.model3.*;
import com.rifu.util.HibernateUtil;

/**
 * ����hibernate�еļ��Ͽ����
 * 
 * 1��Set ���� Ԫ�ز����ظ�
	2��List ���� Ԫ�ؿ��ظ�
	3��Bag ���� Ԫ�ؿ��ظ�
	4��Map ��ֵ��
 * @author Lifu
 *
 */

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
	@Test
	public void getAllStudentImages(){
		List<Image> imageList=new ArrayList<Image>();
		int stuId=1;
		List<Image> lifeImageList=(List<Image>)session.createQuery("from LifeImage l where l.student.id="+stuId).list();
		imageList.addAll(lifeImageList);
		List<Image> workImageList=(List<Image>)session.createQuery("from WorkImage w where w.student.id="+stuId).list();
		imageList.addAll(workImageList);
		Iterator it=imageList.iterator();
		while(it.hasNext()){
			Image image=(Image)it.next();
			System.out.println(image.getImageName());
		}
	}
	
	@Test
	public void testGetAllImages2(){
		Student2 student2=(Student2)session.get(Student2.class, 1);
		Set<Image2> images=student2.getImages();
		Iterator it=images.iterator();
		while(it.hasNext()){
			Image2 image=(Image2)it.next();
			System.out.println(image.getImageName());
		}
	}
	
	@Test
	public void testGetAllImages3(){
		Student3 student3=(Student3)session.get(Student3.class, 1);
		Set<Image3> images=student3.getImages();
		Iterator it=images.iterator();
		while(it.hasNext()){
			Image3 image=(Image3)it.next();
			System.out.println(image.getImageName());
		}
	}
}
