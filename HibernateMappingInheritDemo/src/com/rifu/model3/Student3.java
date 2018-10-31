package com.rifu.model3;

import java.util.HashSet;
import java.util.Set;

import com.rifu.model.Image;

public class Student3 {
	private long id;
	private String name;
	private Set<Image3> images=new HashSet<Image3>();
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
	public Set<Image3> getImages() {
		return images;
	}
	public void setImages(Set<Image3> images) {
		this.images = images;
	}
	
}
