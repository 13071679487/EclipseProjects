package com.rifu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rifu.model.Student;

public class AddStudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("开始添加学生"+student);
		Thread.sleep(5000);
		System.out.println(student+"添加成功");
		return SUCCESS;
	}

}
