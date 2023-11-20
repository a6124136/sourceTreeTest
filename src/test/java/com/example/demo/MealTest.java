package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;

@SpringBootTest (classes = DemoApplication.class)
public class MealTest {
	
	@Autowired
	private MealService mealService;
	
	@Autowired
	private MealDao mealDao;
	
	@Test
	public void addMealTest() {
	Meal res =	mealService.addMeal(new Meal("","水煮",180));
	Assert.isTrue(res==null,"沒名字");
	res = mealService.addMeal(new Meal("牛肉","",180));
	Assert.isTrue(res==null,"沒食譜");
	res = mealService.addMeal(new Meal("牛肉","水煮",-180));
	Assert.isTrue(res==null,"價格小於0");
	res = mealService.addMeal(new Meal("牛肉","水煮",180));
	Assert.isTrue(res!=null,"成功");
	
	mealDao.delete(res);
	}
	@Test
	public void addMeal() {
		mealService.addMeal(new Meal("豬肉","生醃",599));
		mealService.addMeal(new Meal("豬肉","蒸",959));
		mealService.addMeal(new Meal("豬肉","舒肥",219));
		mealService.addMeal(new Meal("豬肉","切片",499));
	}
	@Test
	public void limitMealTest() {
		List<Meal>mealList= mealDao.findFirst3ByName("豬肉");
		Assert.isTrue(mealList.size()==3,"找到的不是三筆");//測試是否有三筆 siez=list長度
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
	}
	@Test
	public void limitMealTest2() {
		List<Meal>mealList= mealDao.findTop5ByNameOrderByPrice("豬肉");
		Assert.isTrue(mealList.size()==5,"找到的不是五筆");//測試是否有5筆 siez=list長度
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
	}
	@Test
	public void limitMealTest3() {
		List<Meal>mealList= mealDao.findTop5ByNameOrderByPriceDesc("豬肉");
		Assert.isTrue(mealList.size()==5,"找到的不是五筆");//測試是否有5筆 siez=list長度
		//這邊的排列反過來的 由大到小
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
	}
	@Test
	public void limitMealTest4() {
//		查全部資料按照價格排序
		List<Meal>mealList= mealDao.findAllByOrderByPrice(); //在強調一次 這個命名真的 很 靠 北 
		for (Meal i:mealList){
			System.out.println("查找全部排序按照價格 食材:"+i.getName()+"料理方式:"+i.getRecipe()+"價格:"+i.getPrice());
		}
	}
	@Test
	public void limitMealTest5() {
//		查找所有價格小於500的資料
		List<Meal>mealList= mealDao.findByPriceLessThanEqual(500);
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
	}
	@Test
	public void limitMealTest6() {
		//名字豬肉 價格大於500
		List<Meal>mealList= mealDao.findByNameAndPriceGreaterThan("豬肉", 500);
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
	}
	@Test
	public void limitMealTest7() {
//		Containing 模糊搜尋
		//模糊搜尋 包含"肉"這個字的食材名字
		List<Meal>mealList= mealDao.findByNameContaining("肉");
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
		System.out.println("=======↑只找name包含'肉'的======找name包含'肉'跟食譜包含'炸'↓=========");
		//模糊搜尋 包含"肉"這個字的食材名字 以及食譜包含"炸"這個字
		mealList =mealDao.findByNameContainingAndRecipeContaining("肉", "炸") ;
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
		
	}
	@Test
	public void limitMealTest8() {
		//Between 找介於這個區段的price 有包含上下限(min max)  而且照順序排
		int min,max;
		min=150;
		max=600;
		List<Meal>mealList= mealDao.findByPriceBetweenOrderByPrice(min, max);
		System.out.println("介於"+min+"到"+max+"之間");
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
		//In 找複數符合條件的資料 反過來還有個NotIn 會排除In條件的 
		System.out.println("findByPriceIn測試"); 
		mealList= mealDao.findByPriceIn(new ArrayList<>(List.of(499,120,50)));
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
		System.out.println("findByPriceNotIn測試 不屬於價格999跟599的");
		mealList= mealDao.findByPriceNotIn(new ArrayList<>(List.of(999,599)));
		for (Meal i:mealList){
			System.out.println("找到"+i.getName()+"料理方式"+i.getRecipe()+"價格"+i.getPrice());
		}
	}
}
