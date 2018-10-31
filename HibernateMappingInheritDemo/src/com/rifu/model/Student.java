package com.rifu.model;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private long id;
	private String name;
	private Set<Image> images=new HashSet<Image>();
	
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
	public Set<Image> getImages() {
		return images;
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}
	
}
