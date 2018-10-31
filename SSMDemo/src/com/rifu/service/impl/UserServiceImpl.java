package com.rifu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rifu.dao.UserDao;
import com.rifu.entity.User;
import com.rifu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
