package com.rifu.service;


import java.util.List;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.mappers.StudentMapper;
import com.rifu.model.Student;
import com.rifu.util.SqlSessionFactoryUtil;

public class StudentTest {
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

	@Test
	public void testInsertStudent() {
		logger.info("���ѧ��");
		Student student=new Student("rifu56",10);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testUpdateStudent() {
		logger.info("�޸�ѧ��");
		Student student=new Student(1,"rifu1",10);
		studentMapper.updateStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testDeleteStudent() {
		logger.info("ɾ��ѧ��");
		studentMapper.deleteStudentById(1);
		sqlSession.commit();
	}
	
	@Test
	public void testFindStudentById(){
		logger.info("����ѧ��");
		Student student = studentMapper.findStudentById(1);
		System.out.println(student);
	}
	
	/**
	 * ��־�����ӿ�����
	 */
	@Test
	public void testGetStudents(){
		logger.info("��������ѧ��");
		List<Student> students = studentMapper.getStudents();
		for(Student stu:students){
			System.out.println(stu);
		}
		sqlSession.commit();
	}
	
}
