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
		name="ѧ���б�";
		return SUCCESS;
	}

	public String add() throws Exception {
		name="���ѧ��";
		return SUCCESS;
	}

	public String update() throws Exception {
		name="�޸�ѧ����Ϣ";
		return SUCCESS;
	}

	public String delete() throws Exception {
		name="ɾ��ѧ��";
		return SUCCESS;
	}

}
