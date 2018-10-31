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
 * 测试hibernate中的集合框架类
 * 
 * 1，Set 无序 元素不可重复
	2，List 有序 元素可重复
	3，Bag 无序 元素可重复
	4，Map 键值对
 * @author Lifu
 *
 */

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
