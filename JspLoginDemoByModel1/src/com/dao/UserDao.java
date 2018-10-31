package com.dao;

import com.rifu.Users;

public class UserDao {
	public boolean login(Users u){
		if("admin".equals(u.getUsername())&&"123456".equals(u.getPassword())){
			return true;
		}
		return false;
	}
}
