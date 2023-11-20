package com.example.demo;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.jupiter.api.Test;

public class LoopTest {
	@Test
	public void loopTest() {
		System.out.println("==================");

		for (int x = 0; x < 8; x++) {
			for (int y = x; y < 8; y++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for (int i = 0; i < 8; i++) {
			for (int j = i; j < 8; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

	@Test
	public void rabbitChicken() {
		int chicken = 0;
		int rabbit;
		a: while (true) {
			rabbit = 35 - chicken;
			if (rabbit * 4 + chicken * 2 == 100) {
				System.out.println("兔子=" + rabbit + "雞=" + chicken);
				break a;
			}
			chicken += 1;
		}
	}

	
	
	boolean notbingo=true;//控制猜數字遊戲的布林值 放全域才能被TimerTask接收到
	
	@Test
	public void guessTest() {
		// 公式:(區間上限-區間下限+1)+區間下限值
		// 1~99:區間上限=90 ;區間下限 = 1
//		double random = Math.random() * (99 - 1 + 1) + 1;
		//轉整數的寫法 int random = (int)(Math.random()*(99-1+1)+1);
		//如果只寫在 Math.random前面的話只會對random起作用 變成0
		// 0*(99-1+1)+1 == 1，結果只會是1		
		// 20~50
//		double random2 = Math.random() * (50 - 20 + 1) + 20;
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		// Random類別 nextInt(i)會產生0~小於輸入參數的值
		//可以填入兩個參數判斷範圍		
		int answer = rand.nextInt(99) + 1;
		int theMin = 1;
		int theMax = 99;
		
		double haha = rand.nextDouble(58.5,90.5);
		System.out.println(haha);
//		呼叫timer
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("超時了，菜，大俠請重新來過");
				notbingo=!notbingo;
				timer.cancel();
				timer.purge();
//				清除計時器任務後 把殘留的任務從執行緒中趕出去?
				System.out.println("答案是"+answer);
				}
		}, 10000);
		
		while (notbingo) {
			System.out.printf("請輸入數字猜猜，最小值%d 最大值%d\n", theMin, theMax);
			int reply = scan.nextInt();
			
			if (reply > theMax) {
				System.out.println("輸入超過最大值喔");
			} else if (reply < theMin) {
				System.out.println("輸入低於最小值喔");
			}
			
			if(reply == answer) {
				System.out.println("答對囉，希望不是計時器告訴你的ㄏㄏ");
				notbingo = !notbingo;
				break;
			}
			
			if (reply > answer) {
				System.out.println("猜太大囉");
				theMax = reply;
			} else{
				System.out.println("猜太小囉");
				theMin = reply;
			}
		}
		scan.close();
	}
}
