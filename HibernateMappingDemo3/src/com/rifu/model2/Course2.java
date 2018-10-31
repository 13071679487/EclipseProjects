package com.rifu.model2;

import java.util.HashSet;
import java.util.Set;
import com.rifu.model2.*;

public class Course2 {
	private long id;
	private String courseName;
	private Set<Student2> students=new HashSet<>();
	
	
	public Set<Student2> getStudents() {
		return students;
	}
	public void setStudents(Set<Student2> students) {
		this.students = students;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
