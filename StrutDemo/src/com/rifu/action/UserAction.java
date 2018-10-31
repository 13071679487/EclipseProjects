package com.rifu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rifu.model.User;
import com.rifu.services.UserServices;

public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserServices userservice=new UserServices();
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		if(userservice.login(user)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
