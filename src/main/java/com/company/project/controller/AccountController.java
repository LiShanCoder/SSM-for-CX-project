package com.company.project.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.project.po.Account;
import com.company.project.service.AccountService;
import com.company.project.vo.JsonMsg;

@Controller
public class AccountController {

	@Resource
	private AccountService accountService;

	@RequestMapping("doLogin")
	public @ResponseBody JsonMsg doLogin(Account account) throws Exception {
		Account db_account = accountService.login(account.getUsername(), account.getPassword());
		if(db_account==null) {
			return new JsonMsg(false, "登陆失败");
		}
		return new JsonMsg(true, "登陆成功");
	}
	
}
