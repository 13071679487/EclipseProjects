package com.rifu.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		System.out.println("请求了ForeAction的execute方法");
		return super.execute();
	}

}
