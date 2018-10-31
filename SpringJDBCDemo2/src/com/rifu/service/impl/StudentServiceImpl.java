package com.rifu.service.impl;

import java.util.List;


import com.rifu.dao.StudentDao;
import com.rifu.model.Student;
import com.rifu.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public int addStudent(Student stu) {
		return studentDao.addStudent(stu);
	}

	@Override
	public int updateStudent(Student stu) {
		return studentDao.updateStudent(stu);
	}

	@Override
	public int deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}

	@Override
	public List<Student> findStudents() {
		return studentDao.findStudents();
	}

}
