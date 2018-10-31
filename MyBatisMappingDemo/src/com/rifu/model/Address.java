package com.rifu.model;

public class Address {
	private Integer id;
	private String sheng;
	private String shi;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", sheng=" + sheng + ", shi=" + shi + "]";
	}
	
}
