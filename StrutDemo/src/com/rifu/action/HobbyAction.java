package com.rifu.action;

import com.opensymphony.xwork2.ActionSupport;

public class HobbyAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] hobby;

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	@Override
	public String execute() throws Exception {
		if(hobby!=null){
			for(String h:hobby){
				System.out.print(h+"\t");
			}
		}
		return SUCCESS;
	}
}
