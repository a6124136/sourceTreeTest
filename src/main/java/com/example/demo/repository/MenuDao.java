package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;


//Data Access Object  = Dao
//這個介面提供方法給JAVA去操作資料庫的Menu表單
//繼承jpa的儲存庫有預設方法能用

// @Repository給Spring boots託管

@Repository     
public interface MenuDao extends JpaRepository<Menu, String>{
	//繼承JpaRepositoy 繼承的jpa介面有一些預設的方法  Menu Entity的@Id (primary key) 類型是String
}
