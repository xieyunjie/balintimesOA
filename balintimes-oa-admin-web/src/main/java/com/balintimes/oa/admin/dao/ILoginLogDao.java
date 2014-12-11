package com.balintimes.oa.admin.dao;

import java.util.List;
import java.util.Map;

import com.balintimes.oa.admin.domain.LoginLog;

public interface ILoginLogDao {
	List<LoginLog> findAllLoginLog();

	List<LoginLog> findLoginLogByUserId(Map<String, Object> map);
	
	int findLoginLogTotalCountByUserId(Integer userId);
}
