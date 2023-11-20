package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

public class Dog  implements RunService{
	private String name="旺財";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void runService() {
		// TODO Auto-generated method stub
		System.out.println(name+"是真正的壞狗狗");
	}
	
}
