package com.balintimes.oa.admin.persistence.mybatis.mappers;

import java.util.List;
import java.util.Map;

import com.balintimes.oa.admin.domain.LoginLog;

public interface LoginLogMapper {
	List<LoginLog> findAllLoginLog();

	List<LoginLog> findLoginLogByUserId(Map<String, Object> map);
	
	int findLoginLogTotalCountByUserId(Integer userId);
}
