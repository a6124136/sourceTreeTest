package com.example.demo.entity;

public class Human extends Animal{
	//繼承了動物的人類
	
	
	public Human() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("我是人類我被創了");
	}

	
	@Override
	public void eat() {
		String name=this.getName();
		name="這個人類";
		System.out.println(name+"正在大吃特吃");
	}
	
	//新的方法
	public void drunkDrive() {
		this.age=58;  //改寫實例的age
		System.out.println("才"+this.age+"歲就酒駕撞死人了");
	}
	
	
}
