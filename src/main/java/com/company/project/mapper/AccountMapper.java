package com.company.project.mapper;

import com.company.project.po.Account;

public interface AccountMapper {

	public Account findAccount_byUsername(String username);
	
}
