package com.rifu.entities;

import java.util.Date;

public class Employee {
	private Integer emp_id;
	private String emp_name;
	private String email;
	private Date birth_day;
	private Date create_time;
	private Department dept;

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(Date birth_day) {
		this.birth_day = birth_day;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String emp_name, String email, Date birth_day, Date create_time, Department dept) {
		super();
		this.emp_name = emp_name;
		this.email = email;
		this.birth_day = birth_day;
		this.create_time = create_time;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", email=" + email + ", birth_day=" + birth_day
				+ ", create_time=" + create_time + ", dept=" + dept + "]";
	}

}
