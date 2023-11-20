package com.example.demo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PersonInfoId implements Serializable{
	private String id;
	
	private String name;

	public PersonInfoId() {
		super();
	}

	public PersonInfoId(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
