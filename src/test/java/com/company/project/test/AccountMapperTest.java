package com.company.project.test;

import javax.annotation.Resource;

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
	public void testFindAccount() {
		Account account = accountMapper.findAccount_byUsername("admin");
		System.out.println(account);
	}
	
}
