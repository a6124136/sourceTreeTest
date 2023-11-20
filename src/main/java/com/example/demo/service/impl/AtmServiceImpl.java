package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repository.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmRes;

@Service
public class AtmServiceImpl implements AtmService {
	@Autowired
	private AtmDao dao;

	@Override
	public AtmRes addInfo(String account, String pwd) {
		Boolean check = dao.existsById(account);

		// 判斷null或空白
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {

//			return new AtmRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMsg(),null);
			// wtf?? AtmRes 拆包RtnCode內的code msg Atm (第三個參數這邊判斷沒有回傳atm資料) 所以是null
			// 回傳RtnCode的PARAM_ERROR狀態錯誤 code=400 msg=參數不對喔 ATM=null
			// 兩種寫法都可以 一個是把RtnCode內的code跟msg拆出來當參數 一個是直接傳整個RtnCode當參數 寫法比較簡潔
			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		if (check) {
			// 改成ACCOUNT_EXISTED 回傳已存在帳號的狀態碼以及訊息
			return new AtmRes(null, RtnCode.ACCOUNT_EXISTED);
			// 另一個構造函數的寫法 (Atm類,RtnCode類)
		}

		Atm res = new Atm(account, pwd);
		// 建立要存的Atm資料
		// Dao.save Atm構造函數 new (acc,pwd,balance)
		// mySQL預設balance是0了所以可以在Atm的Entity裡多弄一個沒有balance的構造函數 只要寫入兩個參數即可
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 呼叫加密的independent (java security maven拿的依賴)

		res.setPassWord(encoder.encode(pwd));
		// 使用encode函式加密密碼後再存
		// 密碼的Char長度要改60 不然加密後長度太長 45塞不進去

		dao.save(res);
		res.setPassWord(""); // 清空密碼 保險
		return new AtmRes(res, RtnCode.SUCCESSFUL); // 這樣寫比較方便閱讀
	}

	@Override
	public AtmRes checkBalanceByAcc(String account, String pwd) {
		if (!StringUtils.hasText(account)) {

			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = dao.findById(account);
		if (op.isEmpty()) {
			// 找不到帳號的狀態碼
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String decodePwd = op.get().getPassWord();
//		String struct = encoder.encode(pwd);
//		dao.findByAccountAndPwd(account,struct);
		if (!encoder.matches(pwd, decodePwd)) {
			// BCryptPasswordEncoder 可以用MATCHES比對欸! 明文跟密文比對6666
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		Atm res = op.get();
		res.setPassWord("");// 回傳前先把密碼屏蔽掉再傳送
		// 成功在回傳ATM資料跟正確的狀態碼
		return new AtmRes(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmRes updatePwd(String account, String oldpwd,String newpwd) {
		if (!StringUtils.hasText(account)) {

			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = dao.findById(account);
		if (op.isEmpty()) {
			// 找不到帳號的狀態碼
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String decodePwd = op.get().getPassWord();
		if (!encoder.matches(oldpwd, decodePwd)) {
			// BCryptPasswordEncoder 可以用MATCHES比對欸! 明文跟密文比對6666
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		String refleshPwd = encoder.encode(newpwd) ;
		Atm res = op.get();
		res.setPassWord(refleshPwd);
		Atm update = dao.save(res);
		res.setPassWord(""); //清空
		return new AtmRes(update, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmRes depositBalance(String account, String pwd, int balance) {
		//存款
		if (!StringUtils.hasText(account)) {

			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = dao.findById(account);
		if (op.isEmpty()) {
			// 找不到帳號的狀態碼
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String decodePwd = op.get().getPassWord();
		if (!encoder.matches(pwd, decodePwd)) {
			// BCryptPasswordEncoder 可以用MATCHES比對欸! 明文跟密文比對6666
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		Atm res =op.get();
		if(balance<0) {
			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		System.out.println("存之前存款為"+res.getBalance());
		
		int sumBalance= res.getBalance()+balance;
		res.setBalance(sumBalance);
		dao.save(res);
		System.out.println("存之後存款為"+res.getBalance());
		res.setPassWord("");
		return new AtmRes(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmRes withdrawBalance(String account, String pwd, int balance) {
		//提款
		if (!StringUtils.hasText(account)) {

			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = dao.findById(account);
		if (op.isEmpty()) {
			// 找不到帳號的狀態碼
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String decodePwd = op.get().getPassWord();
		if (!encoder.matches(pwd, decodePwd)) {
			// BCryptPasswordEncoder 可以用MATCHES比對欸! 明文跟密文比對6666
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		Atm res =op.get();
		
		if(balance>res.getBalance()) {
			//不能領超過存款的錢啊
			return new AtmRes(null, RtnCode.INSUFFICIENT_BALANCE);
		}
		int totalBalance = res.getBalance()-balance;
		System.out.println("提款前為"+res.getBalance());
		res.setBalance(totalBalance);
		
		dao.save(res);
		System.out.println("提款後為"+res.getBalance());
		res.setPassWord("");
		
		return new AtmRes(res, RtnCode.SUCCESSFUL);
	}

	
}
