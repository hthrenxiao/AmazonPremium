package com.amazonpremium.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestBean {
	@Id	
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		return "TestBean [id=" + id + ", name=" + name + "]";
	}
	public TestBean() {
		super();
	}
	public TestBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
