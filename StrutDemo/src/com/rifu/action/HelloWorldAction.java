package com.rifu.action;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ִ����action��execute����");
		return SUCCESS;
	}

}
