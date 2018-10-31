package com.rifu.action;

import com.opensymphony.xwork2.ActionSupport;

public class GradeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String list() throws Exception {
		name="班级列表";
		return SUCCESS;
	}

	public String add() throws Exception {
		name="添加班级";
		return SUCCESS;
	}

	public String update() throws Exception {
		name="修改班级信息";
		return SUCCESS;
	}

	public String delete() throws Exception {
		name="删除班级";
		return SUCCESS;
	}
	
}
