package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.Menu; //引用JAVA與資料庫的媒介實例

//介面提供方法 參數是Menu類的物件


public interface MenuService {	
	public Menu addMenu(Menu menu);
	public List<Menu>  addMenus(List<Menu> menus);
	public Menu updateMenu(Menu menu);
	public Menu findByName(String name);
	public List<Menu> findAll();
}
