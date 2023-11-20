package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmRes;

@SpringBootTest(classes = DemoApplication.class)
public class AtmServiceTest {

	@Autowired
	AtmService service;
	@Test
	public void addInfoTest() {
		AtmRes res = service.addInfo("456455", "65651");
		System.out.println(res.getCode());
		System.out.println(res.getMsg());
		System.out.println(res.getAtm().getAccount());
		System.out.println(res.getAtm().getPassWord());
		
	}
	@Test
	public void checkBalance() {
		AtmRes res=service.checkBalanceByAcc("456455", "65651");
		System.out.println(res.getCode());
		System.out.println(res.getMsg());
		System.out.println(res.getAtm().getBalance());
		System.out.println(res.getAtm().getAccount());
	}
	@Test
	public void checkUpdate() {
		AtmRes res =service.updatePwd("456455", "65651","9527520");
		System.out.println(res.getCode());
		System.out.println(res.getMsg());
		System.out.println(res.getAtm().getAccount());
		System.out.println(res.getAtm().getPassWord());
	}
	@Test
	public void deposit() {
		
		AtmRes res =service.depositBalance("456456", "9527520",2458);
	}
	@Test
	public void withdraw() {
		
		AtmRes res =service.withdrawBalance("456456", "9527520",1111);
		
	}
}
