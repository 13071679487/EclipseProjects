package com.rifu.service;

import com.rifu.model.User;

public class UserService {
	public boolean login(User user){
		if(user!=null){
			if("123".equals(user.getUserName())&&"123".equals(user.getPassword())){
				return true;
			}else{
				return false;
			}
		}
		else return false;
		
	}
}
