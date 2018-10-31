package com.rifu.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public void testSearchStudents() {
		logger.info("��ѯѧ������������");
		Map<String,Object> map=new HashMap<>();
		map.put("gradeId", 1);
		map.put("name", "ri%");
		map.put("age", 22);
		List<Student> students = studentMapper.searchStudents(map);
		for(Student stu:students){
			System.out.println(stu);
		}
		sqlSession.commit();
	}
	
	@Test
	public void testSearchStudents2() {
		logger.info("��ѯѧ������������");
		Map<String,Object> map=new HashMap<>();
		map.put("searchBy", "name");
		map.put("gradeId",2);
		map.put("name", "ri%");
		map.put("age", 22);
		List<Student> students = studentMapper.searchStudents2(map);
		for(Student stu:students){
			System.out.println(stu);
		}
		sqlSession.commit();
	}
	
	/**
	 * 1���Զ����� where��
		2����� where �Ӿ��� and ���� or ��ͷ�����Զ�ɾ����һ�� and ���� or
	 */
	@Test
	public void testSearchStudents3() {
		logger.info("��ѯѧ������������");
		Map<String,Object> map=new HashMap<>();
		map.put("gradeId", 1);
		map.put("name", "ri%");
		map.put("age", 22);
		List<Student> students = studentMapper.searchStudents3(map);
		for(Student stu:students){
			System.out.println(stu);
		}
		sqlSession.commit();
	}
	
	/**
	 * trim
	 * ȥ��sql�е�ǰ׺���ߺ�׺
	 */
	@Test
	public void testSearchStudents4() {
		logger.info("��ѯѧ������������");
		Map<String,Object> map=new HashMap<>();
		map.put("gradeId", 1);
//		map.put("name", "ri%");
//		map.put("age", 22);
		List<Student> students = studentMapper.searchStudents4(map);
		for(Student stu:students){
			System.out.println(stu);
		}
		sqlSession.commit();
	}
	
	/**
	 * foreach
	 */
	@Test
	public void testSearchStudents5() {
		logger.info("��ѯѧ������������");
		Map<String,Object> map=new HashMap<>();
		List<Integer> gradeIds=new ArrayList<>();
		gradeIds.add(1);
		gradeIds.add(2);
		map.put("gradeIds", gradeIds);
//		map.put("gradeId", 1);
//		map.put("name", "ri%");
//		map.put("age", 22);
		List<Student> students = studentMapper.searchStudents5(map);
		for(Student stu:students){
			System.out.println(stu);
		}
		sqlSession.commit();
	}
	
	@Test
	public void testUpdateStudent(){
		logger.info("�޸�ѧ��");
		Student stu=new Student(2,"rifu88",2);
		int result=studentMapper.updateStudent(stu);
		if(result>0)logger.info("�޸�success");
		sqlSession.commit();
	}
	
	
}
