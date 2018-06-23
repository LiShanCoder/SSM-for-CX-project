package com.company.project.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.project.mapper.MoneyMapper;
import com.company.project.service.impl.MoneyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml",
		"classpath:spring/spring-tx.xml"
		})
public class MoneyMapperTest {

	@Resource
	private MoneyMapper moneyMapper;
	
	@Test
	public void testDealMoney() {
		moneyMapper.dealMoney("user1", 100d);
	}
	
	
	
	@Resource
	private MoneyServiceImpl moneyServiceImpl;
	
	@Test
	public void t2() throws Exception {
		moneyServiceImpl.transMoneyTest("user1", "user2", 2d);
	}
	
}
