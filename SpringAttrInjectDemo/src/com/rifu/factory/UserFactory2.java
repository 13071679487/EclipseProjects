package com.rifu.factory;

import com.rifu.model.User;

/**
 * 工厂静态方法生产
 * @author Lifu
 *
 */
public class UserFactory2 {
	public static User createUser(){
		User user=new User(99,"rifu99",20);
		return user;
	}
}
