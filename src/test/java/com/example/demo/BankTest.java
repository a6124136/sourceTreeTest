package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.TaipeiBank;

public class BankTest {
	
	@Test
	public void bankTest() {
		TaipeiBank myBank = new TaipeiBank();
		//創建在全域會有汙染的風險 後者set前者get產生錯誤
		myBank.setBranch("板橋分行");
		myBank.setUser("李大爺");
		myBank.setBalance(5000);
		
		myBank.saving(5000);
		myBank.withDraw(2000);
		myBank.withDraw(10000);
		myBank.checkBalance();
		Assert.isTrue(myBank.getUser()=="李大爺","真假");
//		Assert.isTrue  (斷言)  是否為真 (判斷式,如果不是真的回傳此內容)
//		錯誤的訊息會回傳到JUnit內
		
		System.out.println(fibo(7));
	}

	@Test
	public int fibo(int n) {
		//費波那契
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return fibo(n-1)+fibo(n-2);
			//WHY????????
			//假設fibo(7)
			//5+6 -> 4+3 5+4 -> 3+2 2+1  4+3  3+2 ->
			//拆解成fibo 的 3+2 2+1 3+2 2+1 3+2 
			//fibo(1)跟fibo(2)都==1
			//fibo(3)==fibo(2)+fibo(1)= (0+1)+1 ==2
			//fibo的3+2+2+1+3+2+2+1+3+2 == 實際數字的2+1+1+1+2+1+1+1+2+1
			//fibo(7)==13
			//想出這寫法的人好神
		}
	}
	@Test
	public void construcTest() {
		
	}
}
