package com.rifu.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.mappers.StudentMapper;
import com.rifu.model.Student;
import com.rifu.util.SqlSessionFactoryUtil;

public class StudentTest2 {
	private static Logger logger=Logger.getLogger("StudentTest.class");
	private static SqlSession sqlSession=null;
	private static StudentMapper studentMapper=null;
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	/**
	 * ���ѧ��
	 * ������ǲ���blob��binary large object��,clob��character large object������
	 */
	@Test
	public void testInsertStudent(){
		logger.info("���ѧ��");
		Student stu=new Student();
		stu.setName("�µ�ͬѧ");
		stu.setAge(21);
		stu.setRemark("�ܳ����ı���������...");
		byte[] pic=null;
		try{
			File file=new File("D:/background.jpg");
			InputStream is=new FileInputStream(file);
			pic=new byte[is.available()];
			is.read(pic);
			is.close();
		}catch(Exception e){
			
		}
		stu.setPic(pic);
		int result=studentMapper.insertStudent(stu);
		if(result>0)logger.info("���success");
		sqlSession.commit();
	}
	
	/**
	 * �����������ΪͼƬ
	 */
	@Test
	public void testFindStudentById(){
		logger.info("����ѧ��");
		Student student = studentMapper.findStudentById(8);
		System.out.println(student);
		byte[] pic=student.getPic();
		try{
			File file=new File("d://back000.jpg");
			System.out.println("�����ļ��ɹ�");
			OutputStream os=new FileOutputStream(file);
			os.write(pic);
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("���ҳɹ�");
	}
	
	
}
