package com.rifu.model2;

import java.util.HashSet;
import java.util.Set;


public class Student2 {
	private long id;
	private String name;
	private Set<Image2> images=new HashSet<Image2>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Image2> getImages() {
		return images;
	}
	public void setImages(Set<Image2> images) {
		this.images = images;
	}
	
}
