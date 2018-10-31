package com.rifu.model;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private long id;
	private String name;
	private Set<String> subjects=new HashSet<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}
	
}
