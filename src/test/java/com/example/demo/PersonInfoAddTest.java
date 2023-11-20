package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@SpringBootTest(classes = DemoApplication.class) //這邊要呼叫的class是入口class 不是自己
public class PersonInfoAddTest {
	@Autowired
	private PersonInfoService personInfoService; 
	
	@Autowired
	private PersonInfoDao personInfoDao; 
	
	
	@Test
	public void addPersAonInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入id,姓名，阿拉伯數字年紀,居住地，id必須是大小寫字母開頭，接1~2數字以及後8八碼隨意數字");
		
		String personId = sc.next();
		String personName = sc.next();
		int personAge = sc.nextInt();
		String personCity = sc.next();
		
		//addInfo是改寫JPA的save方法 這個方法如果輸入同樣的pk會覆蓋新的資料 但sql其實不讓輸入同樣pk的 這是jpa的特殊點
		personInfoService.addInfo(new PersonInfo(personId,personName,personAge,personCity));
//		personInfoService.addInfo(new PersonInfo("S154875487","安安",26,"火星"));
		//重複的PK進去的話 他只會刷新後面欄位的值  PK不同才會新增一筆資料
		sc.close();
	}
	
	@Test
	public void daoSaveAllTest() {
//		從Entity那邊創建list
		List<PersonInfo> list =new ArrayList<>();
		list.add(new PersonInfo("A125262446","阿魯",17,"雞窩托斯"));
		list.add(new PersonInfo("A125252636","汪財",57,"狗窩"));
		list.add(new PersonInfo("A125252745","無情孫小美",117,"橋下涵洞"));
//		list陣列加入兩筆變成
		
		personInfoService.addInfoList(list); 
//可以放list array, 這要使用Service內容
//		saveAll可以用ArrayList一次匯入多筆資料
		
	}
	@Test
	public void daoFindTest() {
		
		//這邊的Optional<類別list> JPA自己寫的類別 當用coma看方法的時候可以看後面的解釋來寫要接回來的變數類型
		Optional<PersonInfo> findIdOp = personInfoDao.findById("A1254525413153156");
		if(findIdOp.isEmpty()) {
			//如果接回來的是空的(找不到)
			System.out.println("找不到欸");
			return;
		}
		PersonInfo id= findIdOp.get(); 
		//取得PersonInfo的資料 這邊的get()是從Optional<PersonInfo>轉換回PersonInfo 才能用方法 
		id.getName();//找到名字囉   也可以一路點下去 PersonInfo id= findIdOp.get().getName();
		System.out.println(id.getName());
	}
	@Test
	public void daoFindTest2() {
//		查找全部 回傳PersonInfo清單類別
		List<PersonInfo> personList = personInfoDao.findAll();
		for(PersonInfo i:personList) {
			System.out.println(i.getCity());
//			對清單內每個PersonInfo進行操作，i.getName() 取得資料庫內每筆的name
		}
	}
	@Test
	public void daoFindTest3() {
		Boolean existId = personInfoDao.existsById("A125123545");//查這筆資料存不存在
		System.out.println("id是否存在"+existId);  //單純看有沒有在庫裡面 可以比對是否已有註冊帳號
	}
	@Test
	public void daoFindTest4() {
		//這些是自訂的方法 JPA有規範使用小駝峰寫法 還有By、And這些命名的規範 不然會找不到屬性....怕啦 函數名有影響
		//測試將Dao的函數名稱改成findByNameAndcity City改成小寫會找不到city屬性欸 沙小
		//JPA可以依照命名函數的格式去生成方法  And By Or 和、藉由、或.... 大寫會被認定為屬性名稱 WTF
		//前面+find是找  那+其他的呢?
		
		List<PersonInfo> findCity = personInfoDao.findByCity("洞穴屋");
		
		for(PersonInfo i:findCity) {
			System.out.println(i.getName()+"住在"+i.getCity());
		}
		List<PersonInfo> findNameAndCity = personInfoDao.findByNameAndCity("阿魯", "雞窩托斯");
		for(PersonInfo i:findNameAndCity) {
			System.out.println(i.getName()+"住在"+i.getCity());
		}
		//JPA太強了吧!? 根據函數命名自動生成類似的方法欸幹
		Boolean existsCity= personInfoDao.existsByCity("洞穴屋");
		System.out.println("洞穴屋是否存在?"+existsCity);
	}
	@Test
	public void findAll() {
		personInfoService.readInfo();
	}
	@Test
	public void findByAgeGreaterThan() {
		
		personInfoService.findByAgeGreaterThan(15);
		
	}
	@Test
	public void findAgeBetween() {
		personInfoService.findAgeInfoBetween(10, 50);
	}
	@Test
	public void ageNotBetween() {
		personInfoService.ageNotBetween(10, 20);
	}
	@Test
	public void cityContanting() {
		personInfoService.findByCityContaining("窩");
	}
	@Test
	public void oldAgeFindCity() {
		personInfoService.findByAgeGreaterThanAndCityContainings(20, "狗窩");
		//只輸出年齡大於20住在有窩的人
	}
	@Test
	public void delAll() {
		//不演了 刪庫跑路
		personInfoService.delInfo(null);
	}
}
