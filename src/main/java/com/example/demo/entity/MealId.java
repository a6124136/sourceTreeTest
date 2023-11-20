package com.example.demo.entity;

import java.io.Serializable;

@SuppressWarnings("serial") //序列化Attonash  兩個PK 存成一個Entity 到時候再new實例取用
public class MealId implements Serializable{  
	
// Serializable序列化???
	private String name; 
	
	private String recipe;

	

	public MealId() {
		super();
	}

	
	public MealId(String name, String recipe) {
		super();
		this.name = name;
		this.recipe = recipe;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -980858816996611963L; 亂數序列化

	/**
	 * 這些方法點實作Serializable後可以直接點class名稱調用
	 */
//	private static final long serialVersionUID = 1L;  //Serializable 序列化  
	
}
