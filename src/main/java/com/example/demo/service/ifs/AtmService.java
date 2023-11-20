package com.example.demo.service.ifs;

import com.example.demo.vo.AtmRes;

public interface AtmService {
	public AtmRes addInfo(String account,String pwd);
	public AtmRes checkBalanceByAcc(String account,String pwd);
	public AtmRes updatePwd(String account,String oldpwd,String newpwd);
	public AtmRes depositBalance(String account,String pwd,int balance);
	public AtmRes withdrawBalance(String account,String pwd,int balance);
}
