package com.rifu.factory;

import com.rifu.model.User;

/**
 * ������̬��������
 * @author Lifu
 *
 */
public class UserFactory2 {
	public static User createUser(){
		User user=new User(99,"rifu99",20);
		return user;
	}
}
