package com.rifu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rifu.model.User;
import com.rifu.services.UserServices;

public class UserAction2 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserServices userservice=new UserServices();
	
	private User user;
	
	
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String execute() throws Exception {
		if(userservice.login(user)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
