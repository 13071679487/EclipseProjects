package com.rifu.services;

import com.rifu.model.User;

public class UserServices {
	public boolean login(User user){
		if("123".equals(user.getUsername())&&"123".equals(user.getPassword())){
			return true;
		}
		return false;
	} 
}
