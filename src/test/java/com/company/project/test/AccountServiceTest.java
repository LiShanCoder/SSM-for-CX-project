package com.company.project.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.project.po.Account;
import com.company.project.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:spring/applicationContext-dao.xml",
		"classpath:spring/applicationContext-service.xml"
		})
public class AccountServiceTest {

	@Resource
	private AccountService accountService;

	@Test
	public void testLogin1() throws Exception {
		accountService.login("名字错误", "");
	}
	
	@Test
	public void testLogin2() throws Exception {
		accountService.login("admin", "密码错误");
	}
	
	@Test
	public void testLogin3() throws Exception {
		Account user = accountService.login("admin", "1");
		System.out.println(user);
	}
	
}
