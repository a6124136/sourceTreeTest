package com.example.demo.entity;

public class Bird extends Animal{
	
	
	
	public Bird() {
//		System.out.println("Bird 建構方法");
		//寫在super()前面 super()會紅蚯蚓
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Bird建構方法在Animal之後");
	}
	
	


	//overRide 覆寫父類的同名方法(名稱+參數個素) 覆蓋過去 實例呼叫時會呼叫Bird的方法而不是Animal的方法
	//繼承裡面Override不寫也能運作，但習慣要寫 這樣才知道父類有同名方法
	
	//super用來呼叫父類的方法 取得name的屬性  這樣就算本身不寫name也可以使用
	@Override
	public void eat() {
		System.out.println(super.getName()+"吃得好爽");
	}
	@Override
	public void sleep() {
		this.age = 16;  //
		System.out.println(super.getName()+"睡醒已經"+age+"歲了 (這邊是在bird類裡用this.age方式改寫成16歲)");
	}
	//父類沒有fly這個方法 所以不用標註@Override
	public void fly() {
		System.out.println(super.getName()+"飛個過癮");
	}
	
}
