package com.balintimes.oa.admin.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.balintimes.oa.admin.dao.ILoginLogDao;
import com.balintimes.oa.admin.domain.LoginLog;
import com.balintimes.oa.admin.persistence.mybatis.mappers.LoginLogMapper;

@Repository
public class LoginLogDaoImpl implements ILoginLogDao {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private LoginLogMapper loginLogMapper;

	public List<LoginLog> findAllLoginLog() {
		return loginLogMapper.findAllLoginLog();
	}

	public List<LoginLog> findLoginLogByUserId(Map<String, Object> map) {
		return loginLogMapper.findLoginLogByUserId(map);
	}
	
	public int findLoginLogTotalCountByUserId(Integer userId){
		return loginLogMapper.findLoginLogTotalCountByUserId(userId);
	}
}
