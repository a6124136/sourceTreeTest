package com.example.demo.entity;

public class TaipeiBank {

	private String branch;

	private String user;

	private int balance=1000;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int saving(int howMuch) {

		if (howMuch < 0) {
			System.out.println("不能存負數");
			return balance;
		}
		balance += howMuch;
		return balance;
	}
	
	public int withDraw(int howMuch) {

		if (balance-howMuch < 0&&howMuch>0) {
			System.out.println("不能領超過存款");
			return balance;
		}
		balance -= howMuch;
		return balance;
	}
	
	
	public void checkBalance() {
		System.out.println(this.user+"目前在"+this.branch+"的存款為:"+this.balance);
		
	}

}
