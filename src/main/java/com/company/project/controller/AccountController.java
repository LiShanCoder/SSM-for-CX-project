package com.company.project.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.po.Account;
import com.company.project.service.AccountService;

@Controller
public class AccountController {

	@Resource
	private AccountService accountService;

	@RequestMapping("doLogin")
//	@RequestBody
	public String doLogin(Account account) throws Exception {
		
		return "login.jsp";
	}
	
}
