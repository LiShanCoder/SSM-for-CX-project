package com.company.project.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.company.project.mapper.PowerMapper;
import com.company.project.service.PowerService;

@Service
public class PowerServiceImpl implements PowerService {

	@Resource
	private PowerMapper powerMapper;
	
	@Override
	public List<String> findPowerUrls(Integer account_id) {
		return powerMapper.findPowerUrls(account_id);
	}

}
