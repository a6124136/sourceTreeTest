package com.example.demo;

import java.util.*;

import org.junit.jupiter.api.Test;

public class ArrayTest {

	@Test
	public void arrayTest() {
		// 靜態?
		int[] a = new int[10];
		System.out.println(a.length);
		a[0] = 123;
		a[1] = 5;
		int[] haha = { 50, 56, 55 };
		System.out.println(a[0]);

		System.out.println(a);
		for (int ele : haha) {
			System.out.print(ele);
		}
		ArrayList<String> wtf = new ArrayList<String>();
		wtf.add("哈哈哈哈哈哈");
		wtf.add("笑屁阿樓上的");
		wtf.add("火氣別那麼大嘛");
		wtf.add("誰她媽火氣很大");
		for (String ele : wtf) {
			System.out.println(ele);
		}
		System.out.println("-----------------------------");
		wtf.set(0, "哭阿");
		wtf.set(1, "哭三小");
		wtf.set(2, "沒阿，就想哭");
		wtf.set(3, "哭阿!!");
		for (String e : wtf) {
			System.out.println(e);
		}
	}

	@Test
	public void listTest() {
		List<String> hehe = new ArrayList<String>();
//		List<String>hehe1 = new LinkedList<String>();
		// List 引用的不是類別而是介面(interface)不須用new創建實例
		// 可以按ctrl點一下List查看，介面提供底下的方法來呼叫 本身不提供創建
		// 像是List 底下有ArrayList、LinkedList 要創建的時候呼叫這些即可(List本身不是)

		hehe.add("1564");
		hehe.add("B");
		hehe.add("哭阿");
		System.out.println(hehe);
		// 按照加入的順序排列
		System.out.println(hehe.size() + "窩是List的空間大小");
		// List跟array不一樣 表達空間大小是用size 不是length
		for (int i = 0; i < hehe.size(); i++) {
			System.out.println(hehe.get(i));
		}
//		List<String>haha = List.of("直接放","我想要","的資料","好過癮");
		// 直接賦予初始值的方法 List.of Arrays.asList 必須import util
		// 但是用List.of給予初始值的長度跟內容不可更改 Arrays.asList則是長度不可變但內容可改
//		List<String>haha2 = Arrays.asList("啥","不會吧");//記得+s Array"s"

		System.out.println("以下是List.of跟Array.asList包裹new 建構子的測試喔=======================");
		List<String> haha3 = new ArrayList<String>(List.of("我是List.of喔", "閉嘴啦"));
		List<String> haha4 = new ArrayList<String>(Arrays.asList("我是Arrays.asList喔", "閉嘴啦"));
//		創建一個new 實例(動態)的空間再把固定的List.of跟Arrays.asList放進去，後面還是能新增
		System.out.println("haha3=" + haha3);
		System.out.println("haha4=" + haha4);
		haha3.clear();
		haha4.add("安安，我是新成員，上面的haha3被清除了");
		haha4.set(1, "閉不了嘴了....");
		System.out.println("修改過的haha3=" + haha3);
		System.out.println("修改過的haha4=" + haha4);

	}

	@Test
	public void listForeach() {

		List<String> wtf = new ArrayList<String>(List.of("C", "B", "DD"));
		for (String e : wtf) {
			System.out.println(e);
		}
		// LAMDA寫法 (跟箭頭符號有什麼關係?)
		wtf.forEach(e -> {
			System.out.println(e);
		});

	}

	@Test
	public void findSingle() {
		Scanner scan = new Scanner(System.in);
		System.out.println("輸入數字找質數");
//		找質數

		List<Integer> PrimeArr = new ArrayList<>();
//		宣告List類型要大寫開頭全名阿....

		int wtf;
		wtf = scan.nextInt();
		boolean isPrime;

		for (int i = 2; i <= wtf; i++) {
			isPrime = true;

			for (int j = 2; j < Math.sqrt(i)+1; j++) {

				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				PrimeArr.add(i);

			}

		}
		System.out.println(PrimeArr);
//		-----------------------------------------------------------------
		scan.close();
	}
}
