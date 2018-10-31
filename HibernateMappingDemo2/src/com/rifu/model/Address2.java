package com.rifu.model;

public class Address2 {
	private long id;
	private String addressName;
	private String code;
	private User2 user;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User2 getUser() {
		return user;
	}
	public void setUser(User2 user) {
		this.user = user;
	}
	
}
