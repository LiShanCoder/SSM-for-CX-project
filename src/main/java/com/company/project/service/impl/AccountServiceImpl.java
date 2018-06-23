package com.company.project.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.company.project.mapper.AccountMapper;
import com.company.project.po.Account;
import com.company.project.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountMapper accountMapper;
	
	@Override
	public Account login(String username, String password) throws Exception {
		Account db_user = accountMapper.findAccount_byUsername(username);
		if(db_user==null) {
			throw new Exception("用户不存在");
		}
		if(!db_user.getPassword().equals(password)) {
			throw new Exception("密码错误");
		}
		return db_user;
	}

}
