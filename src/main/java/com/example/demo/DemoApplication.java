package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication (exclude= {SecurityAutoConfiguration.class})
									//排除這個? Spring Security的預設登入 後續controller會解釋
									//環境配置加上spring-boot-starter-security會影響
public class DemoApplication {
	
//	記得分號很重要
	
	public static void main(String[] args) {
		//            main 專案的入口 所有程式都在這邊執行
		SpringApplication.run(DemoApplication.class, args);
		int balance = 10;
		int arc = balance*10;
		System.out.println(arc);
		Scanner myName = new Scanner(System.in);
		System.out.println("請輸入你的名字");
		String userName = myName.next(); //int 變數名 =  new Scanner.nextInt 可以強制型態
		System.out.println("我的名字叫做"+userName);
		double dice = 3.14159;
		System.out.println("圓周率"+dice+3);
		myName.close();
	}
}
class animal{
	protected String acient = "草履蟲";  //祖先名稱
	public void bark() {            //祖先方法
	    System.out.println("嗡嗡");
	}
}
class rabit extends animal{
	private String petName = "小兔崽子";
	 public static void main(String[] args) {
		 rabit babyrabit = new rabit();
		 System.out.println(babyrabit.petName+"的祖先是"+babyrabit.acient);
		 String trash ="拉基";
		 boolean check = true;
		 System.out.println(trash+check+babyrabit.petName.length());
		 //拉基+true+小兔崽子的字數
		 
	 }
}
class textNumber{
	public static void main(String[] args)
	{	
		int x = 5;
		char IamChar='A';
		String y = "  heros";
		System.out.print(x);//不換行
		System.out.println(x);//換行
//		這邊的 print"f" f是format 格式化輸出，用這個才可以使用%d%s的用法
//		可以把游標移到printf上面看介紹 預設不會換行所以加上\n進行換行
		System.out.printf("x=%d,HeroIs%s 強制換行\n",x,y);//printf (字串包變數的類別,變數...)
		//%d取代數字 %s取代字串		
		System.out.printf("哈哈%c 強制換行\n",IamChar); //字串內插入反斜線n換行 下一行不會接在後面
		
		//任何變數不確定，後面加個.可以看有沒有跳出方法來判斷是不是屬於物件
		Integer k=3526;
		String o = "在o跟k的後面加個.就能看到我們能使用的方法";
		System.out.println("第x位是:"+o.charAt(x));//找到第x位的單字
		System.out.println(k.doubleValue());//換算成double的數值
		Scanner putin = new Scanner(System.in);
		int a,b;
		String haha;
		a = putin.nextInt();
		b = putin.nextInt();
		haha = putin.next();
		System.out.println(a+"\t"+b+"\t"+haha);
		putin.close();
;	}
}