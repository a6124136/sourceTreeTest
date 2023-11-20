package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="person_info")
@IdClass(value=PersonInfoId.class)//引入保管複合PK的Entity
public class PersonInfo {
	@Id
	@Column(name="ID")
	private String id;
	@Id
	@Column(name="name")
	private String name;
	@Column(name="agel")
	private int age;
	@Column(name="city")
	private String city;

	public PersonInfo() {
		super();
	}

	//資料媒介...  ctrl+shift+o 可以呼叫import頁面 看看目前還在紅蚯蚓的引用清單
	public PersonInfo(String id, String name, int age, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
