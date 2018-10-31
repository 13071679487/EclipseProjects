package com.rifu.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rifu.model.User;
import com.rifu.service.UserService;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private String error;
	private UserService userService=new UserService();
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	@Override
	public String execute() throws Exception {
		if(userService.login(user)){
			ActionContext actionContext=ActionContext.getContext();
			Map<String, Object> session=actionContext.getSession();
			session.put("currentUser", user);
			return SUCCESS;
		}else{
			this.error="用户名或密码错误";
			return "error";
		}
	}

}
