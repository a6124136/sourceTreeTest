package com.example.demo.vo;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;

//Vo= Value Object 複合型資料存放處 res req之類的
public class AtmRes {
	//包裝Code msg atm返還
	
	private int code;
	
	private String msg;
	
	private Atm atm;
	
	private RtnCode rtnCode;
	
	public AtmRes() {
		super();
	}
	

	public AtmRes(Atm atm, RtnCode trnCode) {
		super();
		this.atm = atm;
		this.rtnCode = trnCode;
	}


	public AtmRes(int code, String msg, Atm atm) {
		super();
		this.code = code;
		this.msg = msg;
		this.atm = atm;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}


	public RtnCode getTrnCode() {
		return rtnCode;
	}


	public void setTrnCode(RtnCode trnCode) {
		this.rtnCode = trnCode;
	}
	
}
