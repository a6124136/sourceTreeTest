package com.example.demo.entity;

public class Monkey {
	//私有類別僅供自己成員使用
	private String name;
	
	private String color;
	
	private int age;
	
	
	//構造函數的命名必須跟類名同樣 而且不需要任何修飾符(void、String等....)只要有權限而且跟類名同名
	public Monkey(String name, String color, int age) {
		super();//繼承父類
		this.name = name;
		this.color = color;
		this.age = age;
		//這邊this指的就是這個class
	}
	//source construtor usefield
	//同名構造函數跟一般方法一樣 參數資料型態順序或個數不同就可以同名 端看呼叫創建時採用哪一種方法
	public Monkey() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	//source construtor super
	
	
	public void scream() {
		System.out.println(age+"歲的"+color+"猴子"+name+"吱吱叫");
	}




	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public void ride(String mybike,int route, boolean accident) {
		String ifaccident;
		if(accident) {
			ifaccident="摔車了";
		}else {
			ifaccident="竟然沒摔";
		}
		
		System.out.println("猴子"+this.name+"是"+this.color+"的破猴，今年"+this.age+"歲，很會飆車");
		System.out.println("騎著"+mybike+"騎了"+route+"公里後"+ifaccident);
	}
	
	public void huntMonkey() {
		System.out.println(name+"安安 我沒static");
	}
	// static差異 可以看MonkeyTest的解釋
	public static void huntMonkey2() {
		System.out.println("安安 我有static");
	}
	
	
}