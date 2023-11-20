package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String>{
	//                   針對PersonInfo表的Dao 每個Dao都對應一張表的資料庫操作
	
	//JPA沒提供 自訂的搜尋方法↓ 從city屬性查找 回傳的會是list (因為不只一筆)
	public List<PersonInfo> findByCity(String city);
	public List<PersonInfo> findByNameAndCity(String name,String city);
	public Boolean existsByCity(String city);
	public List<PersonInfo> findAll();
	public List<PersonInfo> findByAgeGreaterThan(int age);
	public List<PersonInfo> findTop2ByAgeBetween(int min,int max);
	public List<PersonInfo> findByAgeGreaterThanAndAgeLessThanOrderByAgeDesc(int min,int max);
											//兩個不同大小比較之間也要加上屬性名 第二個就不用加上by了
	public List<PersonInfo> findByCityContaining(String conddition);
	public List<PersonInfo> findByAgeGreaterThanAndCityContaining(int age,String city);
}
