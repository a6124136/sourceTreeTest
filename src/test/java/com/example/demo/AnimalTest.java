package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.Car;
import com.example.demo.entity.Dog;
import com.example.demo.entity.Human;

@SpringBootApplication
public class AnimalTest {
	
//	繼承關係的測試
	
	@Test
	public void animalExtendsTest() {
		Animal myanimal = new Animal();
		System.out.println("new bird ↓繼承了animal 建構時會先跑父類的建構方法再跑子類的");
		Bird mybird = new Bird();
		System.out.println("new bird ↑繼承了animal 建構時會先跑父類的建構方法再跑子類的");
		System.out.println("父類別 動物名稱:"+myanimal.getName());
		myanimal.eat();
		myanimal.sleep();
		System.out.println("子類別Bird繼承把拔名稱:"+mybird.getName());
		mybird.setName("金絲雀");
		System.out.println("子類別修改動物名稱後:"+mybird.getName());
		System.out.println("overRide改寫父類的同名方法eat、sleep");
		mybird.eat();
		mybird.sleep();
		mybird.fly();
	}
	@Test
	public void humanExtendsTest() {
		Human myMan=new Human();
		Animal animal = new Animal();
		myMan.drunkDrive();
		myMan.eat();
		System.out.println(myMan instanceof Animal);
		System.out.println(animal instanceof Human);
		//測驗是否隸屬於對方的類底下
	}
	@Test
	public void polymorphism() {
//		繼承關係的多形
		Animal anim = new Animal();
		anim.eat();
		Bird bird = new Bird();
		bird.eat();
		System.out.println("=========================================");
		Animal animm = new Animal();
		animm.eat();
		Animal birdd = new Bird();
		birdd.eat(); //呼叫的是Animal的eat方法(但執行時因為動態多形會執行子類別的eat)
		//以父類別創建  但輸出結果與上方一致
		//執行的多形 呼叫的是父類別 但創造的是子類別實體，呼叫執行會跑去子類執行 (但系統顯示為父類的eat)
		//但是以父類別創建的子類實體 沒有子類自己獨有的屬性或方法，只能使用父類別提供的方法
//		birdd.fly();  飛不起來
		
	}
	@Test
	public void interfaceTest() {
		Dog mydog=new Dog();
		Car mycar=new Car();
		mydog.runService();
		mycar.runService();
		
	}
}
