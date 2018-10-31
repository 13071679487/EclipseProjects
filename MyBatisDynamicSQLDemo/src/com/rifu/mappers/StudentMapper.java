package com.rifu.mappers;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.rifu.model.Student;

public interface StudentMapper {
	public List<Student> searchStudents(Map<String,Object> map);
	public List<Student> searchStudents2(Map<String,Object> map);
	
	/**
	 * 1，自动加上 where；
		2，如果 where 子句以 and 或者 or 开头，则自动删除第一个 and 或者 or
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
