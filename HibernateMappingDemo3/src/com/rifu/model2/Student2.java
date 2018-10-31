package com.rifu.model2;

import java.util.HashSet;
import java.util.Set;

public class Student2 {
	private long id;
	private String stuName;
	private Set<Course2> courses=new HashSet<Course2>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Set<Course2> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course2> courses) {
		this.courses = courses;
	}
	
}
