package com.rifu.model;


public class User {
	private int id;
	private String name;
	private int age;
	private String className;
	private Dog dog;
	
	
	
	public User() {
		System.out.println("user±ª≥ı ºªØ");
	}
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", className=" + className + ", dog=" + dog + "]";
	}
	
	
}
