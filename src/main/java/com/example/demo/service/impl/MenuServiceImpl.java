package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;


//實作的區塊  在 package內使用@Service讓spring boot託管方法

@Service  //方法託管在實作這一塊 Service 被託管的不論是Entity或是Service都是bean
public class MenuServiceImpl implements MenuService{
	//@:annotation
	
	@Autowired  //呼叫SB託管的MenuDao
	private MenuDao menuDao;
	
//	addMenu 是MenuService 這個介面提供的方法 
//	呼叫繼承了JPA的MenuDao來改寫這個方法
	
	@Override
	public Menu addMenu(Menu menu) {
		String checkName = menu.getName();
		Boolean hasText = StringUtils.hasText(checkName);
		int lessPrice = menu.getPrice(); 
		Boolean idExists = menuDao.existsById(checkName);
		if(!hasText||lessPrice<=0||idExists) {
//			System.out.println("餐點沒填寫名稱或價格，或是已有存在餐點");
			return null;
		}
		System.out.println("新增 餐點:"+menu.getName()+" 價格:"+menu.getPrice()+"元");	
		return menuDao.save(menu);  //JPA的方法有提供回傳值
		//這個被改寫的方法 是jpa提供的 呼叫menuDAO(繼承JPA) 才能改寫
	}

	@Override
	public List<Menu> addMenus(List<Menu> menus) {
		for(Menu i:menus) {
			if(!StringUtils.hasText(i.getName())||i.getPrice()<=0) {
				return null;
			}
			System.out.println("新增 餐點:"+i.getName()+" 價格:"+i.getPrice()+"元");
		}
		System.out.println("已將多筆資料存入資料庫");
		
		return menuDao.saveAll(menus); //存取list並回傳;
	}

	@Override
	public Menu updateMenu(Menu menu) {
		String checkName = menu.getName();
		Boolean idExists = menuDao.existsById(checkName);
		String previosName = menuDao.findById(checkName).get().getName();
		int previosPrice = menuDao.findById(checkName).get().getPrice();
		//修改前的資料
		if(idExists) {
			System.out.println("確認有該筆資料");
			System.out.println("修改前餐點:"+previosName+"修改前價格"+previosPrice+"元");
			System.out.println("==============================================");
			System.out.println("修改後餐點:"+menu.getName()+"修改後價格"+menu.getPrice()+"元");
		}else{
			System.out.println("查無此資料");
			return null;
	
		}
		return menuDao.save(menu);
	}

	@Override
	public Menu findByName(String name) {
		Optional<Menu> op = menuDao.findById(name); //Optional類還要再拆包
		Menu op2 = op.get();
		if(op2!=null) {
			System.out.println("查到惹 餐點名:"+op2.getName()+" 價格:"+op2.getPrice());
		}else {
			System.out.println("沒料");
		}
		return op.isEmpty()?  op2:null;  //空的回null 不空回拆包的menu
//		return op.orElse(null);  //JPA本身提供的方法 有東西就回傳 沒有就退貨 更方便
		
	}

	@Override
	public List<Menu> findAll() {
		List<Menu> menuList = menuDao.findAll();
		for(int i=0;i<menuList.size();i++) {
			String menuNames=menuList.get(i).getName();
			int menuPrices=menuList.get(i).getPrice();
			System.out.println("第"+(i+1)+"筆  餐點:"+menuNames+"價格:"+menuPrices);
		}
		return menuDao.findAll();
	}
}
