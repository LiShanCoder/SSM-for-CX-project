package com.company.project.service;

import com.company.project.po.Account;

public interface AccountService {
	
	public Account login(String username, String password) throws Exception;
	
}
