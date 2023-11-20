package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;


@Service //記得要加Service
public class MealServiceImpl implements MealService{
	
	@Autowired
	private MealDao mealDao;  //託管的Dao引入
	

	@Override    //改寫Service
	public Meal addMeal(Meal meal) {
		String name = meal.getName();
		String recipe =meal.getRecipe();
		int price = meal.getPrice();
		if(name.trim()==""||recipe.trim()==""||price<=0) {
			System.out.println("阿你怎麼連輸入都輸不好");
			return null;
		}
		if(mealDao.existsById(new MealId(name,recipe))) {
			
			//哇幹 太酷了吧 把複數主鍵存到Entity裡面 用new Id類別(pk1,pk2)的方式就能呼叫了欸
			
			System.out.println("阿你怎麼連輸入都輸不好");
			return null;
		}
		System.out.println("恭喜妳啊，"+name+"用"+recipe+"的方式，價格為"+price+"元");
		return mealDao.save(meal);
	}

	@Override
	public Meal findByName(String name) {
		
		return null;
	}
	
}
