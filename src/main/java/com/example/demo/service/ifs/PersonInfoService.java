package com.example.demo.service.ifs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonInfo;

@Service   //Spring託管  有@Service才能用@Autowired呼喚
public interface PersonInfoService {
	//針對表的服務
	public void addInfo(PersonInfo person);
	public void addInfoList(List<PersonInfo> personList);
	public List<PersonInfo> readInfo();	 //findAll
	public void delInfo(PersonInfo person);
	public List<PersonInfo> findAgeInfoBetween(int min ,int max);
	public void findByAgeGreaterThan(int age);
	public void ageNotBetween(int min ,int max);
	public void findByCityContaining(String conddition);
	public void findByAgeGreaterThanAndCityContainings(int age,String city);
}
