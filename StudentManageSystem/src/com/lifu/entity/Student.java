package com.lifu.entity;

import java.util.Date;
/**
 * ѧ����
 * @author Lifu
 *
 */
public class Student {
	private int id;
	private String stuName;
	private String stuNo;
	private String sex;
	private Date birthday;
	private int gradeId=-1;
	private String email;
	private String stuDesc;
	
	public Student(){}
	
	

	public Student(String stuName, String stuNo, String sex, Date birthday, int gradeId, String email, String stuDesc) {
		super();
		this.stuName = stuName;
		this.stuNo = stuNo;
		this.sex = sex;
		this.birthday = birthday;
		this.gradeId = gradeId;
		this.email = email;
		this.stuDesc = stuDesc;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStuDesc() {
		return stuDesc;
	}

	public void setStuDesc(String stuDesc) {
		this.stuDesc = stuDesc;
	}

}
