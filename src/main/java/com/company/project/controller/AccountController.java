package com.company.project.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.project.po.Account;
import com.company.project.service.AccountService;
import com.company.project.service.PowerService;
import com.company.project.vo.JsonMsg;

@Controller
public class AccountController {

	@Resource
	private AccountService accountService;
	
	@Resource
	private PowerService powerService;

	@RequestMapping("doLogin")
	public @ResponseBody JsonMsg doLogin(HttpSession session, Account account) throws Exception {
		Account db_account = accountService.login(account.getUsername(), account.getPassword());
		if(db_account==null) {
			return new JsonMsg(false, "登陆失败");
		}
		List<String> db_urls = powerService.findPowerUrls(db_account.getId());
		session.setAttribute("account", db_account);
		session.setAttribute("urls", db_urls);
		return new JsonMsg(true, "登陆成功");
	}
	
	@RequestMapping("doLogout")
	public @ResponseBody JsonMsg doLogout(HttpSession session) throws Exception{
		return new JsonMsg(true, "退出登陆");
	}
	
	@RequestMapping("fun1")
	public @ResponseBody JsonMsg fun1(){
		return new JsonMsg(true, "");
	}

	@RequestMapping("fun2")
	public @ResponseBody JsonMsg fun2(){
		return new JsonMsg(true, "");
	}
	
}
