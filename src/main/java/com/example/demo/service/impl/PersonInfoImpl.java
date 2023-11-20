package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@Service
public class PersonInfoImpl implements PersonInfoService{
	@Autowired
	private PersonInfoDao PersonInfodao;
	
	
	@Override
	public void addInfo(PersonInfo person) {
		String condition = "[A-Za-z][1-2][0-9]{8}";
		if(person.getId()==null||person.getId().length()==0) {
			System.out.println("id不可為空");
			return;   //ID必須先進行null測試 因為null無法使用matches 會出錯
		}else if(!person.getId().matches(condition)) {
			System.out.println("請輸入正確的id格式");
			return;
		}
		PersonInfodao.save(person);
	}
	
	
	@Override
	public List<PersonInfo> readInfo(){  //查找全部
		List<PersonInfo> allInfo = PersonInfodao.findAll();
		for(PersonInfo i:allInfo) {
			String name,city;
			name =i.getName();
			city=i.getCity();
			System.out.println(name+"住在"+city);
		}
		
		return PersonInfodao.findAll();
	}
	@Override
	public void delInfo(PersonInfo person) {
		PersonInfodao.deleteAll();//刪庫跑路
	}

	@Override
	public void addInfoList(List<PersonInfo> personList) {
		String condition = "[A-Za-z][1-2][0-9]{8}";
		for(PersonInfo i:personList) {
			String id=i.getId();
			String name=i.getName(),city=i.getCity();
			if(id.length()!=0&&!id.matches(condition)) {
				System.out.println("缺少ID或不符合ID格式");
				return;
			}else if(!PersonInfodao.findByNameAndCity(name, city).isEmpty()) {
				System.out.println("包含相同姓名與居住地!");
				return;
			}
		}
		
		PersonInfodao.saveAll(personList);
		for(PersonInfo i:personList) {
			String id=i.getId();
			String name=i.getName(),city=i.getCity();
			System.out.println("ID:"+id+" 姓名:"+name+" 居住地:"+city);
		}
	}


	@Override
	public void findByAgeGreaterThan(int age) {
		List<PersonInfo> ageThanInfo =PersonInfodao.findByAgeGreaterThan(age);
		for(PersonInfo i:ageThanInfo) {
			System.out.println(i.getName()+"住在"+i.getCity()+"今年"+i.getAge()+"歲");
		}
	
	}


	@Override
	public List<PersonInfo> findAgeInfoBetween(int min, int max) {
		List<PersonInfo> ageIn = PersonInfodao.findTop2ByAgeBetween(min, max);
		System.out.println("只找2筆 findTop2");
		for(PersonInfo i:ageIn) {
			String name=i.getName(),city=i.getCity();
			int age =i.getAge();
			System.out.println("年齡在"+min+"到"+max+"之間的 姓名:"+name+" 居住地:"+city+age+"歲");
		}
		return ageIn;
	}


	@Override
	public void ageNotBetween(int min, int max) {
		List<PersonInfo> hehe=PersonInfodao.findByAgeGreaterThanAndAgeLessThanOrderByAgeDesc(min, max);
		for(PersonInfo i:hehe) {
			String name=i.getName(),city=i.getCity();
			int age =i.getAge();
			System.out.println("年齡不在"+min+"到"+max+"之間的 姓名:"+name+" 居住地:"+city+age+"歲");
		}
	}


	@Override
	public void findByCityContaining(String conddition) {
		List<PersonInfo>spicifCity =  PersonInfodao.findByCityContaining(conddition);
		for(PersonInfo i:spicifCity) {
			String name=i.getName(),city=i.getCity();
			int age =i.getAge();
			System.out.println(age+"歲的老BABY"+name+"住在"+city);
		}
	}


	@Override
	public void findByAgeGreaterThanAndCityContainings(int age, String city) {
		List<PersonInfo>spicifCity =  PersonInfodao.findByAgeGreaterThanAndCityContaining(age, city);
		for(PersonInfo i:spicifCity) {
			String name=i.getName();
			System.out.println("大於"+age+"歲的老BABY"+name+"住在"+city);
		}
	}
	
}
