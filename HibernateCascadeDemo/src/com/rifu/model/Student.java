package com.rifu.model;

public class Student {
	private long id;
	private String name;
	private Class c;
	
	public Student() {
		super();
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}

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
	public Class getC() {
		return c;
	}

	public void setC(Class c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
