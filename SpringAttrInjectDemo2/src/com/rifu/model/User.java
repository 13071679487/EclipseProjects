package com.rifu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private int age;
	private Dog dog;
	
	private List<String> hobbies=new ArrayList<>();
	private Set<String> likes=new HashSet<>();
	private Map<String ,String> loves=new HashMap<>();
	private Properties insteres=new Properties();
	
	
	public User() {
		super();
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
	public void setAge(int age) {
		this.age = age;
	}
	
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	
	
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Set<String> getLikes() {
		return likes;
	}
	public void setLikes(Set<String> likes) {
		this.likes = likes;
	}
	public Map<String, String> getLoves() {
		return loves;
	}
	public void setLoves(Map<String, String> loves) {
		this.loves = loves;
	}
	
	
	public Properties getInsteres() {
		return insteres;
	}
	public void setInsteres(Properties insteres) {
		this.insteres = insteres;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", dog=" + dog.getName() + ", hobbies=" + hobbies
				+ ", likes=" + likes + ", loves=" + loves + ", insteres=" + insteres + "]";
	}
	
	
}
