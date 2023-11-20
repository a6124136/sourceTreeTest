package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@SpringBootTest(classes = DemoApplication.class)
public class MenuServiceTest {
//	架構一堆有的沒的 終於要來測試操控資料庫囉 讚讚    魯麻 傳不進去 爛爛  11/10 我好爛 改了sql密碼沒改propertity
	@Autowired 
	private MenuService menuService; 
	@Autowired 
	private MenuDao menuDao; 
	
	@Test
	public void addMenuTest() {
		
		Menu res = menuService.addMenu(new Menu("仙人茶",180)); //回傳menu 或null
		Assert.isTrue(res != null,"正常加入");
		res = menuService.addMenu(new Menu("",100));
		Assert.isTrue(res == null,"空白名稱 加入失敗");
		res = menuService.addMenu(new Menu("仙人茶",100));
		Assert.isTrue(res == null,"已有同樣餐點");
		res = menuService.addMenu(new Menu("仙人茶",0));
		Assert.isTrue(res == null,"價格為0");
		// 測試報錯會中斷 並顯示Assert內部的訊息告訴我們哪個環節錯誤
		menuDao.deleteById("仙人茶");
		//測試完刪除資料
	}
	
	@Test
	public void addMenusTrst() {  //多筆資料
		List<Menu> menuList = new ArrayList<>();
		menuList.add(new Menu("香酥魚卵膏",50));
		menuList.add(new Menu("大熊貓麻婆豆腐",70));
		menuService.addMenus(menuList);  //回傳list
		
	}
	@Test
	public void updateMenu() {
		menuService.updateMenu(new Menu("香酥魚卵膏",100));  //回傳null或修改後的新資料
		
	}
	@Test
	public void findByName() {
		String target = "大熊貓麻婆豆腐";
		//name就是Id 其實findById也一樣
		Menu res = menuService.findByName(target); //回傳null 或查找到的資料
		Assert.isTrue(res==null,"沒找到");
	}
	@Test
	public void findAll() {
		//參考PersonInfo的daoFindTest2寫法
		menuService.findAll();
		
	}
}
