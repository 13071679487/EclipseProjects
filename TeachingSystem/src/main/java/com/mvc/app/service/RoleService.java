package com.mvc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.dao.RoleMapper;
import com.mvc.app.model.Role;
import com.mvc.app.model.RoleExample;
import com.mvc.app.model.RoleExample.Criteria;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	//注册，添加role
	public void addRole(Role role){
		System.out.println("ready to register..");
		roleMapper.insertSelective(role);
		System.out.println("register..end");
	}
	//检查登录用户名和密码
	public boolean checkLogin(String rname,String password){
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRnameEqualTo(rname);
		criteria.andPasswordEqualTo(password);
		Role role=roleMapper.selectByExample(example).get(0);
		if(role.getRname()!=null && role.getPassword().equals(password)){
			return true;
		}
		return false;
	}
	
	public Role getRoleByExample(String rname,String password){
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRnameEqualTo(rname);
		criteria.andPasswordEqualTo(password);
		Role role=roleMapper.selectByExample(example).get(0);
		if(role.getRname()!=null && role.getPassword().equals(password)){
			return role;
		}
		return null;
	}
}
