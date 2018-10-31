package com.rifu.model;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private long id;
	private String stuName;
	private Set<Course> courses=new HashSet<Course>();
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
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
