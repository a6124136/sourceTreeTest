package com.example.demo;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class RegexpTest {
	@Test
	public void regTest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入09**-***-***格式的電話號碼");
		String phone = sc.next();
		String conditions = "09\\d{2}(-\\d{3}){2}"; 
		//    -\\d{3}重複了，可以括號分組起來()綁成一組 共循環兩次{2}
//		String jumpExit = "\";   //單獨一個\會報錯 可以解除註解看看
		//反斜線是跳脫符號 所以想寫\d{4}會報錯 必須再多加一行\才可以用，不能單獨存在
		// 但也例外 像是\f 換頁符號 \n 換行
		System.out.println(phone+"格式是"+phone.matches(conditions));
		// target.matched(REG條件)判斷
		sc.close();
	}
	@Test
	public void regTest2() {
		String conditions = "\\(\\d{2}\\)-\\d{8}";
		//格式(兩碼)-八碼 包含小括號 小括號前面加上\\ 避免被判定成分組符號
		String str = "(02)-54875487";
		boolean testfoo=str.matches(conditions);
		System.out.println(testfoo);
	}
	@Test
	public void regTestHomework() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入09**-***-***格式的手機號碼或(**)-7~8碼格式的市話號碼");
		String phone = sc.next();
		String conditions = "09\\d{2}(-\\d{3}){2}"; 
		String conditions2 = "\\(\\d{2}\\)-\\d{7,8}";//{最小,最大}
		if(phone.matches(conditions)||phone.matches(conditions2)) {
			System.out.println("測驗格式通過");
		}else {
			System.out.println("Sorry不通過");
		}
		sc.close();
	}
	@Test
	public void regTestHomework2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入0開頭的2~4碼-7~8碼的市話號碼");
		String phone = sc.next();
		String conditions = "0\\d{1,3}-\\d{7,8}";
		System.out.println("您輸入的號碼"+phone+"為"+phone.matches(conditions));
		sc.close();
	}
	@Test
	public void idTest() {
//	身分證測試	
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入大小寫字母開頭後面數字1或2以及8位數字的身分證字號");
		String id = sc.next();
		String conditions = "[A-Za-z][1-2][0-9]{8}";
		System.out.println("輸入的身分證是否PASS:"+id.matches(conditions));
		//排除ABDEFH
		String conditions2 = "[CGI-Zcgi-z][1-2][0-9]{8}";//暴力破解
		String conditions3 = "[A-Za-z&&[^ABD-FHabd-fh]][1-2]\\w{8}";//特殊字元
		System.out.println("輸入的身分證是否PASS: 暴力破解:"+id.matches(conditions2));
		System.out.println("輸入的身分證是否PASS: 特殊字元:"+id.matches(conditions3));
		sc.close();
	}
	@Test
	public void regTest3() {
		//用正則尋找並排除字串內的特定字
		
		// ^ 開頭符號  $ 結尾符號 ^A*B$  符合A開頭B結尾的範圍 A1235B  true  AsasdSD5B true
		// [^a-zA-z] 但開頭符號放在[]range之中 意思是排除 這邊意思是排除a-zA-Z，其餘的都算true
		//  .*  0到多個萬用符號  中間一段放什麼都OK的話可以用這個 .萬用字元  *前方的字可以出現0~多個
		// [A-Z&&[^AB]].* 這句就是開頭大寫字母 而且排除A跟B 後面可以隨意接0~多個  
		String str ="Hello! JAVA I love yoooou JAVA"; 
		String condition = "JAVA";
		System.out.println(str.replaceFirst(condition,"JavaScript"));
		System.out.println(str.replace(condition,"JavaScript"));
		condition = ".*JAVA.*"; //前後符合可以0~多個萬用字元 ==內文有JAVA就算true (不能在開頭或結尾)
		System.out.println(str.replaceFirst(condition,"JavaScript"));
		condition = "JAVA.*";// 只換掉第一個JAVA後面所有字的條件
		System.out.println(str.replaceFirst(condition,"JavaScript"));
		
		
		
	}
}
