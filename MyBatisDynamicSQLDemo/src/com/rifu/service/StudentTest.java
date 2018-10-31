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
		logger.info("查询学生（带条件）");
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
		logger.info("查询学生（带条件）");
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
	 * 1，自动加上 where；
		2，如果 where 子句以 and 或者 or 开头，则自动删除第一个 and 或者 or
	 */
	@Test
	public void testSearchStudents3() {
		logger.info("查询学生（带条件）");
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
	 * 去掉sql中的前缀或者后缀
	 */
	@Test
	public void testSearchStudents4() {
		logger.info("查询学生（带条件）");
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
		logger.info("查询学生（带条件）");
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
		logger.info("修改学生");
		Student stu=new Student(2,"rifu88",2);
		int result=studentMapper.updateStudent(stu);
		if(result>0)logger.info("修改success");
		sqlSession.commit();
	}
	
	
}
