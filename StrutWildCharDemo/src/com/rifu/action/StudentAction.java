package com.rifu.action;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

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
		name="学生列表";
		return SUCCESS;
	}

	public String add() throws Exception {
		name="添加学生";
		return SUCCESS;
	}

	public String update() throws Exception {
		name="修改学生信息";
		return SUCCESS;
	}

	public String delete() throws Exception {
		name="删除学生";
		return SUCCESS;
	}

}
