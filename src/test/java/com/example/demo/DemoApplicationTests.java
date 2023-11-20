package com.example.demo;
//  package的路徑  src/test/java com.example.demo
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
//類別
	//這邊的斜體@Test 指的是我們可以單獨在這邊測試方法 如果不+就不能測試
	@Test
	public void firstTest(){
	//方法
		//這邊的public是權限 void這個方法不回傳任何東西  如果有回傳值的話 就改填上回傳資料的類型
		//權限  回傳的類型  方法名(參數){方法邏輯內容}
		int a = 5;
		float b =.54f;
		long  haha = 1231235464565456L;
		byte c = 127;
		Scanner sc = new Scanner(System.in);
		System.out.println(a+b+haha+c+"安安 隨便輸入些什麼吧");
		String str = sc.next();
		System.out.println(str+"大笨蛋");
		sc.close();
	}
}
