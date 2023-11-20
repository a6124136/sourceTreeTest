package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table (name = "meal")
@IdClass (value = MealId.class) //用另一個entity管控複數PK的寫法 注意這邊使用的是value 不是name
public class Meal implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //序列化?
	
	
	@Id
	@Column (name="name")
	private String name;   //雙PrimaryKey
	@Id
	@Column (name = "recipe")
	private String recipe;
	@Column (name = "price")
	private int price;

	public Meal() {
		super();
	}

	public Meal(String name, String recipe, int price) {
		super();
		this.name = name;
		this.recipe = recipe;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
