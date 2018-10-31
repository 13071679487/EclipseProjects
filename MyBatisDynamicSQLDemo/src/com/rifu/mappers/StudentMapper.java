package com.rifu.mappers;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.rifu.model.Student;

public interface StudentMapper {
	public List<Student> searchStudents(Map<String,Object> map);
	public List<Student> searchStudents2(Map<String,Object> map);
	
	/**
	 * 1���Զ����� where��
		2����� where �Ӿ��� and ���� or ��ͷ�����Զ�ɾ����һ�� and ���� or
	 * @param map
	 * @return
	 */
	public List<Student> searchStudents3(Map<String,Object> map);
	
	public List<Student> searchStudents4(Map<String,Object> map);
	
	public List<Student> searchStudents5(Map<String,Object> map);
	
	public int updateStudent(Student stu);
	
	public int insertStudent(Student stu);
	
	public Student findStudentById(Integer id);
	
	public List<Student> getStudents(RowBounds rb);
	public List<Student> getStudents2(Map<String,Object> map);
}
