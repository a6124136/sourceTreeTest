package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atm")
public class Atm {
	@Id
	@Column(name = "account")
	private String account;
	@Column(name = "password")
	private String pwd;
	@Column(name = "balance")
	private int balance;

	
	//小tip 構造函數預設的super 一定要有 不然資料庫找不到
	public Atm() {
		super();
	}

	public Atm(String account, String passWord) {
		super();
		this.account = account;
		this.pwd = passWord;
	}

	public Atm(String account, String passWord, int balance) {
		super();
		this.account = account;
		this.pwd = passWord;
		this.balance = balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassWord() {
		return pwd;
	}

	public void setPassWord(String passWord) {
		this.pwd = passWord;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
