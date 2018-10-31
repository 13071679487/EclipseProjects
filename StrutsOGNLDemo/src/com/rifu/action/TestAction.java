package com.rifu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.rifu.model.User;

public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private List<User> users;
	
	private Map<String,User> userMap;
	
	

	public Map<String, User> getUserMap() {
		return userMap;
	}


	public void setUserMap(Map<String, User> userMap) {
		this.userMap = userMap;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		// 获取狭义上的值栈
		ValueStack valueStack=actionContext.getValueStack();
		valueStack.set("name", "张三(valueStack)");
		valueStack.set("age", 11);
		
		Map<String, Object> session=actionContext.getSession();
		session.put("name", "王五(session)");
		session.put("age", 13);
		
		Map<String, Object> application=actionContext.getApplication();
		application.put("name", "赵六(application)");
		application.put("age", 14);
		
		user=new User("2276",21);
		users=new ArrayList<User>();
		users.add(new User("2277",22));
		users.add(new User("2278",23));
		
		userMap=new HashMap<String,User>();
		userMap.put("good", new User("学霸",13));
		userMap.put("bad", new User("学渣",13));
		return SUCCESS;
	}

}
