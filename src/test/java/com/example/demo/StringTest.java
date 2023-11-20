package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

public class StringTest {
	@Test
	public  void stringTest() {
		char[] ch= {'字','串','練','習','鎮','列'};
		String str1 =new String();
		String str2 =new String(ch);
		String str3 =new String(str2);
		str1 = str2;
		String str4 = "字串練習鎮列";
		String str5 = "字串練習鎮列";
		System.out.println("str1"+str1);
		System.out.println("str2"+str2);
		System.out.println("str3"+str3);
		System.out.println("str3==str1?"+str3.equals(str1));
		System.out.println("str3==str2?"+str3.equals(str2));
		System.out.println("str3==str4?"+str3.equals(str4));
		System.out.println(str4==str5);//同樣的字串但創建在不同的記憶體空間 所以不相等
		
		
		String wtf="黃河流水流河黃";
		System.out.println(wtf.indexOf('流'));
		//測試查找第幾位 從左開始找 2
		System.out.println(wtf.lastIndexOf('流'));
		//從右開始找 4 同樣的流 找到的順序不同
	}
	@Test
	public  void stringTest1() {
		String str ="ABC";
		String str1 ="";
		String str2 ="  ";//空白
		System.out.println(str.length());
		System.out.println(str1.length());
		System.out.println(str2.length());
		//長度分別為 3 0 2 
		System.out.println(str2.isBlank());//有沒有包含空白或是空值
		System.out.println(str2.isEmpty());//是否為空值  有空白所以不是空值
		System.out.println(StringUtils.hasText(str2)); //只有空白沒有內文 = false
		System.out.println(StringUtils.hasLength(str2));//空白有長度 = true
	}
	@Test
	public  void eagleCouple() {
		String str ="神鵰俠侶是楊過與茱麗葉的故事，我不喜歡茱麗葉的甲仙，雖然茱麗葉在楊過眼中是清新脫俗";
		int index=0,count=0;
		//索引值  計數值
		
		
		String target="茱麗葉";
		while(str.indexOf(target,index)!=-1) {
			index=str.indexOf(target,index)+target.length();
			//按照目標的字串長度跳著搜尋 用變數的長度當每次跳的弧度就可以動態搜尋
			//迭代靠index  
			count++;
		}
		System.out.println(count);
//		for(;str.indexOf(target,index)!=-1;) {
//		index = str.indexOf(target,index)+target.length();
//		count++;  //酷酷的寫法
//			}
//		}
	}
	@Test
	public void replaceTest() {
		String str ="神鵰俠侶是楊過與茱麗葉的故事，我不喜歡茱麗葉的甲仙，雖然茱麗葉在楊過眼中是清新脫俗";
		str = str.replace("楊過","梁山伯");
		//另外一個replaceAll的可以使用Regex找字串
		//兩者都是取代全部符合條件的字串
		//replaceFirst只取代找到的第一個
		System.out.println(str);
		str = str.replaceAll("梁山伯", "武大郎");
		System.out.println(str);
		
	}
	@Test
	public void splitTest() {
		//切割字串
		String str ="神鵰俠侶是楊過與茱麗葉的故事，我不喜歡茱麗葉的甲仙，雖然茱麗葉在楊過眼中是清新脫俗";
		String target = "茱麗葉";
		String[] array= str.split(target);
		for(String item:array) {
			System.out.println(item);
		}
		String[] array2= str.split("，"); //去除逗號分段
		for(String item:array2) {
			System.out.println(item);
		}
		String haha="ABCD";
		String[] array3= haha.split("");//空字串把字串全部分成字元
		for(String item:array3) {
			System.out.println(item); //ABCD
		}
	}
	@Test
	public void trimTest() {
		String str="abc def";
		String str1=" abc def ";
		System.out.println(str==str1);
		System.out.println(str.equals(str1));
		str=str.trim();
		str1=str1.trim();
		System.out.println(str==str1);//不用equals一樣是false 比較字串必須使用equals(記憶體位置)
		System.out.println(str.equals(str1));
		System.out.println(str);
		System.out.println(str1);
		
	}
	@Test
	public void substringTest() {
		String str = "神鵰俠侶是楊過與茱麗葉的故事，我不喜歡茱麗葉的甲仙，雖然茱麗葉在楊過眼中是清新脫俗";
		String str1 =str.substring(5, 11);
		String str2 =str.substring(str.length()-5);//倒數五字
		System.out.println(str1);
		System.out.println(str2);
		String women = "茱麗葉";
		String women2 = "祝英台";
//		int lastWomen =  str.lastIndexOf(women);
//		String str3 = str.substring(lastWomen);
//		String str4;
//		str4 = str3.replaceFirst(women,"祝英台");
//		str=str.replace(str3, str4);
//		System.out.println(str);//成功把最後一個茱麗葉換成祝英台了
		int index=0;
		int count=0;
		while(str.indexOf(women,index)!=-1) {
			index=str.indexOf(women,index)+women.length();
			count++;
		}
		str=str.replace(women, women2);
		for(int i=0;i<count-1;i++) {
			str=str.replaceFirst(women2, women);
		}
		System.out.println(str); //改最後一個成祝英台  比第一個方法好一點 穩定搜索換到只剩最後一個
		//先計算出總共要換的數量 然後全部換成祝英台 最後再把總數-1喚回茱麗葉  這樣就只剩最後一個是祝英台了
	}
	@Test
	public void stringBufferTest() {
//		StringBuffer 本身不是字串,但是串接時不會占用新的記憶體空間 而是在原本的記憶體空間增刪改
//		這類別因為不是字串，所以串街後必須用toString轉字串
		StringBuffer sb =new StringBuffer("參考");
		sb.append("看看");
		sb.append("走過路過");
		sb.append("別錯過");
		System.out.println(sb);
		
		StringBuffer sb1 = new StringBuffer("參考");
		StringBuffer sb2 = new StringBuffer("參考");
		System.out.println(sb1.equals(sb2));
		//直接相比較 false
		System.out.println(sb1.toString().equals(sb2.toString()));
		//轉換成字串相比較 true
	}
	@Test
	public void replaceTry() {
		String str = "ABACADEF";
		String target = "A";
		String change = "W";
		int lastChar =  str.lastIndexOf(target); //找出最後一個A
		String str3 = str.substring(lastChar); //str3 從A開始的最後一段
		String str4;
		str4 = str3.replaceFirst(target,change);//str4取代str3第一個A換成W 
//		str = str.replace(str3, str4);//原本的字串把最後一段(str3)換成修改後的str4 會有重複風險
		str = str.substring(0, lastChar)+str4;
		//這樣寫更好 原本字串擷取到最後一段前面，最後加上修改後的最後一段
		
		System.out.println(str);
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(lastChar, 'A');//StringBuilder可以指定索引值換字元(限定字元)
		sb.reverse();//反轉
		System.out.println(sb);
		
	}
	@Test
	public void reverseTest() {
		Scanner putin = new Scanner(System.in);
		//條件寫法
		while(true) {
			System.out.println("測驗回文至少三字");
			String str = putin.next();
			if(str.length()<3) {
				continue;//跳過重回到true
			}else {				
				StringBuilder sb = new StringBuilder(str);
				String ifEqual = sb.reverse().toString();
				System.out.println("是否回文?="+str.equalsIgnoreCase(ifEqual));
			}
			break;
		}
		//JAVA的字串都要轉StringBuilder或StringBuffer才有好用的控制方法嗎?
		putin.close();
	}
	@Test
	public void listTest() {
			
		Scanner haha = new Scanner(System.in);
		int hehe = haha.nextInt();
		hehe++;
		//輸入數字  +1
		String str = String.valueOf(hehe);
		//int的值轉字串
		String[] strArray = str.split("");
		//分割成字串陣列
		List<String> myarray =	new ArrayList<>(Arrays.asList(strArray));
		//Array記得+s 用ArrayList把字串陣列轉list格式 (這樣才能打印出來，直接打印是記憶體空間 )  
		System.out.println(myarray);
		haha.close();
	}
}
