package com.rifu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rifu.model.User;

public class RegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("ÐÂ×¢²áÓÃ»§£º"+user);
		return SUCCESS;
	}
	
}
