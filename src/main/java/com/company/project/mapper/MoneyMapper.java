package com.company.project.mapper;

import org.apache.ibatis.annotations.Param;

public interface MoneyMapper {
	public void dealMoney(@Param("username") String username, @Param("money") Double money);
	public Double findMoney(String uesrname);
}
