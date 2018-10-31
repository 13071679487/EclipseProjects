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
	 * ��ҳ��ѯѧ��
	 * ���ַ�ʽΪ�߼���ҳ�����ǽ������������������ݶ�ȡ���ڴ棬�ٵ��ڴ��ȡ- �趨����--������
	 * ���������ĺܴ�
	 */
	@Test
	public void testGetStudents(){
		logger.info("����ѧ��");
		int offset=0;//�൱��start
		int limit=3;
		RowBounds rb=new RowBounds(offset,limit);
		List<Student> students = studentMapper.getStudents(rb);
		for(Student student:students){
			System.out.println(student);
		}
		logger.info("���ҳɹ�");
	}
	
	/**
	 * ��ҳ��ѯѧ��
	 * ���ַ�ʽΪ�����ҳ�������Լ�ƴдsql���limit start,num
	 */
	@Test
	public void testGetStudents2(){
		logger.info("����ѧ��");
		Map<String,Object> map=new HashMap<>();
		map.put("start", 0);
		map.put("limit", 3);
		List<Student> students = studentMapper.getStudents2(map);
		for(Student student:students){
			System.out.println(student);
		}
		logger.info("���ҳɹ�");
	}
	
	
	
	
}
