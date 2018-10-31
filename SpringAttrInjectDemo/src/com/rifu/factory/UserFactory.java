package com.rifu.factory;

import com.rifu.model.User;

public class UserFactory {
	public User createUser(){
		User user=new User(1,"rifu90",20);
		return user;
	}
}
