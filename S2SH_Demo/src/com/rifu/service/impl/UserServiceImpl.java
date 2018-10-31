package com.rifu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rifu.dao.BaseDao;
import com.rifu.entity.User;
import com.rifu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private BaseDao<User> baseDao;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		baseDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		baseDao.update(user);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return baseDao.get(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		baseDao.delete(user);
	}

	@Override
	public List<User> findAllList() {
		// TODO Auto-generated method stub
		return baseDao.find("from User");
	}

	@Override
	public User findUserByNameAndPassword(User user) {
		// TODO Auto-generated method stub
		return baseDao.get("from User u where u.userName=? and u.password=?", new Object[] {user.getUserName(),user.getPassword()});
	}

}
