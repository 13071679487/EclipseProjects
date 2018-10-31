package com.rifu.model;

import java.util.HashMap;
import java.util.Map;

public class Student4 {
	private long id;
	private String name;
	private Map<String,String> subjects=new HashMap<>();
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
	public Map<String, String> getSubjects() {
		return subjects;
	}
	public void setSubjects(Map<String, String> subjects) {
		this.subjects = subjects;
	}
	
}
