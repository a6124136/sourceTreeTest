package com.example.demo.entity;

public class Animal {
	
	private String name="窩4動物";
	
	protected int age =18;
	//可以被Bird類用super.age引用
	
	public Animal() {
//		System.out.println("Animal constructor");
		super();  //如果寫在super()之前會紅蚯蚓
		
		// TODO Auto-generated constructor stub
		System.out.println("我是Animal的建構方法 子類建構之前要先跑過我");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(name+"正在吃");
	}
	public void sleep() {
		System.out.println(name+"正在睡");
	}
}
