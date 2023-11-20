package com.example.demo;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class ConditionTest {
	int a = 5;
	int b = 6;
	int[] arr= {5,6,7,78,8};
	
	@Test // 一開始會是紅蚯蚓 按ctrl點一下可以召喚import的選項
	public void inputTest() {
		System.out.println("請輸入成績");
		Scanner haha = new Scanner(System.in);
		int score = haha.nextInt(); 
		switch(score/10) {

		case 10:
			System.out.println("A+");
			break;
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		case 5:
			System.out.println("E");
			break;
		default:
			System.out.println("F");
			break;
		}
		// ctrl+shift+f 整理版面
		haha.close();	
	}
	@Test // 一開始會是紅蚯蚓 按ctrl點一下可以召喚import的選項
	public void ifTest() {
		
		System.out.println(a);
		System.out.println(b);
		for(int item:arr) 
		System.out.println(item);
		
	}
	@Test
	public void scanerTest() {

		Scanner haha = new Scanner(System.in);
		System.out.println("請輸入字串");
		String x = haha.next();
		System.out.println(x);
		System.out.println("請輸入整數");
		int y = haha.nextInt();
		System.out.println(y);
		haha.close();
		}
	@Test
	public void scanerTest2() {
		
		Scanner haha = new Scanner(System.in);
		System.out.println("中間輸入空白或是分兩次輸入，兩個字串成一個句子");
		String x = haha.next();
		String y = haha.next();
		System.out.println(x+"←X、Y→"+y);
		
		System.out.println("請輸入完整句子");
		String z = haha.nextLine();//這個可以輸入整句話，next會被空白分割成兩段 但這個不會
		System.out.println(z);
		haha.close();
		}
	@Test
	public void scanerTest3() {
		
		Scanner haha = new Scanner(System.in);
		System.out.println("輸入數字");
		int x = haha.nextInt();
		System.out.println(x+"我的數字");
		haha.close();
		}
	
	@Test
	public void weekdayTest() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入星期?(數字)");
		int toDate = scan.nextInt();
		System.out.println("請輸入幾天後?(數字)");
		int dayAfter = scan.nextInt();
		int calcReslut = (toDate+dayAfter);
		//封裝方法調用函數 (因為做的事情一樣)		
		String theToDay=switchClosure(toDate);
		String theWeekDay=switchClosure(calcReslut);		
		System.out.printf("今天是星期%s %d天後是星期%s\n",theToDay,dayAfter,theWeekDay);
//		System.out.println("來畫個星星吧 輸入數字決定畫多少星星");
		scan.close();
		}
//			↓被調用的函式 把數字轉成中文
		private String switchClosure(int result) {
			String outputDay="";
		switch(result%7) {
		case 0:
			outputDay="日";
			break;
		case 6:
			outputDay="六";
			break;
		case 5:
			outputDay="五";
			break;
		case 4:
			outputDay="四";
			break;
		case 3:
			outputDay="三";
			break;
		case 2:
			outputDay="二";
			break;
		case 1:
			outputDay="一";
			break;
			}
		return outputDay;
		}
	}
