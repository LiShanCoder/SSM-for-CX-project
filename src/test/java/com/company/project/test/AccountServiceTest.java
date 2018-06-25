package com.company.project.test;

import javax.annotation.Resource;

import org.junit.Assert;
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
	public void login_1() {
		try {
			accountService.login("名字错误", "");
		} catch (Exception e) {
			String[] ex = {"用户不存在"};
			String[] ac = {e.getMessage()};
			Assert.assertArrayEquals("", ex, ac);
		}
	}
	
	@Test
	public void login_2() throws Exception {
		try {
			accountService.login("admin", "密码错误");
		} catch (Exception e) {
			String[] ex = {"密码错误"};
			String[] ac = {e.getMessage()};
			Assert.assertArrayEquals("", ex, ac);
		}
	}
	
	@Test
	public void login_3() throws Exception {
		Account user = accountService.login("admin", "1");
		
		String[] ex = {"admin", "1"};
		String[] ac = {user.getUsername(), user.getPassword()};
		Assert.assertArrayEquals("", ex, ac);
	}
	
}
