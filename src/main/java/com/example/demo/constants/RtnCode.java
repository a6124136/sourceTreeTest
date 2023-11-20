package com.example.demo.constants;


//enum  列舉   -> 這邊放一些返還的狀態常量  出錯的時候會根據錯誤回報該錯誤的回答(vo裡的AtmRes處理)
//☆注意!★ enum不是class 
public enum RtnCode {
//	狀態碼  類似404not found 跟200成功那樣 通知出錯的項目是什麼
	
	//列舉必須要用逗號分隔  
	SUCCESSFUL(200,"成功 恭喜妳啊小王八羔子"),//
	PARAM_ERROR(400,"參數不對喔"),//
	ACCOUNT_EXISTED(400,"已經有這筆帳號囉 你這沒創意的小笨蛋"),
	BAD_RUQUES(400,"客戶端(你)的錯"),//
	ACCOUNT_NOT_FOUND(404,"找不到你的帳號欸 你確定在這邊加的會員嗎?"),
	INSUFFICIENT_BALANCE(400,"錢不夠你提阿窮鬼"),
	;//
	
	
	
	private int code;
	private String msg;
	
	//要建構方法才能讓列舉的狀態碼使用
	private RtnCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	
	public String getMsg() {
		return msg;
	}

}
