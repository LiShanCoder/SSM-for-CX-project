package com.company.project.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.company.project.mapper.MoneyMapper;

@Service
public class MoneyServiceImpl {

	@Resource
	private MoneyMapper moneyMapper;
	
	public void transMoneyTest(String from, String to, Double money) throws Exception {
		if(money<=0) {
			throw new Exception("");
		}
		moneyMapper.dealMoney(to, money);
		Double db_m = moneyMapper.findMoney(from);
		if(db_m<money) {
			throw new Exception("账户余额不足");
		}
		moneyMapper.dealMoney(from, -money);
	}
	
}
