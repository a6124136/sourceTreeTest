package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository    //記得要加上Repository託管
public interface MealDao extends JpaRepository<Meal, MealId>{
//	複數Id已經放到MealId這個Entity了 Jpa不接受Id參數兩個以上 所以用MealId這個class存放所有pk管理
//	JPA可以根據函數命名可以生成方法 小駝峰寫法 要做的動作跟屬性名都要大寫開頭 
	//Order語句要放最後面 因為排序是最後要做的事情 
	//詳細寫法可以去JPA DOC看看
	
	//限制搜尋回傳的筆數=3  top跟first效果一樣
		public List<Meal>  findFirst3ByName(String name);
	//限制搜尋回傳的筆數=5 按照價格排序 (預設Asc 由小到大排序)
	public List<Meal>  findTop5ByNameOrderByPrice(String name);
	//           上面的倒序(Desc由大到小)
	public List<Meal>  findTop5ByNameOrderByPriceDesc(String name);
	//查找全部不需要參數 排序依照價格排列由小到大 這命名方式真的好靠北 ByOrderBy屬性  可是前面有特定屬性的不需要加上By在Order前面
	public List<Meal> findAllByOrderByPrice();
	//比較大小語法:
	//1. 大於 GreaterThan  大於等於 GreaterThanEqual
	//2. 小於 LessThan  小於等於 LessGreaterThanEqual
	
	//找小於等於的 參數=目標值
	public List<Meal> findByPriceLessThanEqual(int price);  
	
	//找同名裡面 大於的         寫法   By屬性名 "And" 屬性名+條件   By屬性名 "Or" 屬性名+條件  
	// 如果不加條件的話只用ByPrice的話 他會去搜索"等於"	
	public List<Meal> findByNameAndPriceGreaterThan(String name,int price);  
	
	//Containing 模糊搜尋 名字內包含參數
	public List<Meal> findByNameContaining(String name);
	
	//Containing 模糊搜尋 名字、食譜內包含參數
	public List<Meal> findByNameContainingAndRecipeContaining(String name,String recipe);
		
	//Between 介於兩者之間 (區間) 有包含min跟max 然後排序
	public List<Meal> findByPriceBetweenOrderByPrice(int min,int max);
	
	//In 多數特定條件
	public List<Meal> findByPriceIn(List<Integer> priceList);
	//NotIn 排除多數特定條件
	public List<Meal> findByPriceNotIn(List<Integer> priceList);
}
