package com.company.project.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.project.mapper.PowerMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"classpath:spring/applicationContext-dao.xml"
})
public class PowerMapperTest {

	@Resource
	private PowerMapper powerMapper;
	
	@Test
	public void findPower() {
		List<String> urls = powerMapper.findPowerUrls(1);
		System.out.println(urls);
	}
	
}
