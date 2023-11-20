package com.example.demo;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Monkey;
//引用已經建立好的實體的Monkey類別

//class 類的練習

public class MonkeyTest {
	@Test
	public void monkeyClassTest() {
		
		Monkey myMonkey = new Monkey();
		System.out.println(myMonkey.getName());
		
		
		myMonkey.setAge(20);
		myMonkey.setName("吉米");
		myMonkey.setColor("黃色");
		myMonkey.ride("大B",5,true);
		Monkey myMonkey2 = new Monkey();
//		沒設定過的新猴子什麼都沒有
		myMonkey2.ride("腳踏車",13,false);
		//new一個Monkey用set跟get慢慢寫太多行
		//在Monkey類裡面先寫好構造函數(右鍵source創建)，屬性當參數寫好就可以了
		Monkey construcMonkey = new Monkey("潑猴","綠",18);
		//新的構造函數直接將參數傳入set屬性 減少一堆set方法
		System.out.println("----↓構造函數出來的猴子使用scream");
		construcMonkey.scream();
		System.out.println("----↓需要new實體才能使用的方法");
		myMonkey.huntMonkey();
		System.out.println("----↓statci直接能用類別呼叫，不需要創建實體");
		Monkey.huntMonkey2();
		
		//加了static跟沒加的區別
		Math.random();
		//Math類底下的random方法有static 可以直接呼叫使用
		//工具類
		Random ran =new Random();
		ran.nextInt();
		//沒加static就必須創建實體才能呼喚使用
//		final double a =3.141596;
//		a=50; 報錯 final不可被更改
	}	
}