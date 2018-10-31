package com.rifu.dao;

import java.util.List;

import com.rifu.model.Student;

public interface StudentDao {
	public int addStudent(Student stu);

	public int updateStudent(Student stu);

	public int deleteStudent(int id);

	public List<Student> findStudents();
}
