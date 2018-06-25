package com.company.project.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.project.mapper.AccountMapper;
import com.company.project.po.Account;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"classpath:spring/applicationContext-dao.xml"
})
public class AccountMapperTest {

	@Resource
	private AccountMapper accountMapper;
	
	@Test
	public void findAccount() {
		Account account = accountMapper.findAccount_byUsername("admin");
		
		Assert.assertNotEquals("找不到账户", null, account);
		
		String[] expected = {"admin", "1"};
		String[] actual = {account.getUsername(), account.getPassword()};
		Assert.assertArrayEquals("找到的账户信息不正确", expected, actual);
	}
	
}
