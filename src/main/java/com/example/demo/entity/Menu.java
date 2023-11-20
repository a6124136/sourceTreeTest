package com.example.demo.entity;

import javax.persistence.Column; //引入欄
import javax.persistence.Entity; //被託管的實例
import javax.persistence.Id;     //主鍵
import javax.persistence.Table;  //引入表


//persistence 持續存在  恆久性的 JAVA Persistence Api  JPA


//資料庫與實例連結的Class  JAVA跟mySQL之間的橋樑 

@Entity                // JAVA在創建時就會new一個託管等我們用??
@Table(name = "menu")  //連結表名 name=表單名
public class Menu {
	@Id                    //Primary Key 標示主鍵 在主鍵欄位上用@Id標記
	@Column(name = "name") //連結欄位名 name=欄位名稱
	private String name;   //主鍵是String 那在interface MenuDao裡面就要指定 Menu類的String 
	
	@Column(name = "price") //連結欄位名 name=欄位名稱
	private int price;
	
	
	public Menu() {
		super();
		//基本構造函數
	}
	
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
		//帶屬性參數的構造函數
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
