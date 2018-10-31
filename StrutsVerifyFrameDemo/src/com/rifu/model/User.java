package com.rifu.model;

public class User {
	public String userName;
	public String name;
	public int age;
	public String email;
	public String homePage;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", age=" + age + ", email=" + email + ", homePage="
				+ homePage + "]";
	}

}
