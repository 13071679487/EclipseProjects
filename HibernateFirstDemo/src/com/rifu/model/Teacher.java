package com.rifu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 使用注解方式ORM
 * @author Lifu
 *
 */
@Entity
@Table(name="t_teacher")
public class Teacher {
	private long id;
	private String name;
	
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(generator="_native")
	@GenericGenerator(name="_native",strategy="native")
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

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}
	
}
