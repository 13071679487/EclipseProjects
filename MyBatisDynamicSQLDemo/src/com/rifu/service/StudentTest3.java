package com.rifu.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.mappers.StudentMapper;
import com.rifu.model.Student;
import com.rifu.util.SqlSessionFactoryUtil;

public class StudentTest3 {
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
	 * 分页查询学生
	 * 这种方式为逻辑分页，就是将符合条件的所有数据读取到内存，再到内存读取- 设定条数--的数据
	 * 这样的消耗很大
	 */
	@Test
	public void testGetStudents(){
		logger.info("查找学生");
		int offset=0;//相当于start
		int limit=3;
		RowBounds rb=new RowBounds(offset,limit);
		List<Student> students = studentMapper.getStudents(rb);
		for(Student student:students){
			System.out.println(student);
		}
		logger.info("查找成功");
	}
	
	/**
	 * 分页查询学生
	 * 这种方式为物理分页，就是自己拼写sql语句limit start,num
	 */
	@Test
	public void testGetStudents2(){
		logger.info("查找学生");
		Map<String,Object> map=new HashMap<>();
		map.put("start", 0);
		map.put("limit", 3);
		List<Student> students = studentMapper.getStudents2(map);
		for(Student student:students){
			System.out.println(student);
		}
		logger.info("查找成功");
	}
	
	
	
	
}
