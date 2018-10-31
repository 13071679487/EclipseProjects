package com.rifu.service;

import java.util.List;

import com.rifu.model.Student;

public interface StudentService {
	public int addStudent(Student stu);

	public int updateStudent(Student stu);

	public int deleteStudent(int id);

	public List<Student> findStudents();
}
