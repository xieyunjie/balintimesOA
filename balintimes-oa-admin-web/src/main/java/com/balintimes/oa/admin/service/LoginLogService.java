/**
 * 用户登录历史服务
 * Author: bing.ning@balintimes.com
 * Date: 2014-12-03
 */
package com.balintimes.oa.admin.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balintimes.oa.admin.dao.ILoginLogDao;
import com.balintimes.oa.admin.domain.LoginLog;

@Service
public class LoginLogService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ILoginLogDao loginLogDao;

	public List<LoginLog> findAllLoginLog() {
		return loginLogDao.findAllLoginLog();
	}

	public List<LoginLog> findLoginLogByUserId(Map map) {
		return loginLogDao.findLoginLogByUserId(map);
	}

	public int findLoginLogTotalCountByUserId(Integer userId) {
		return loginLogDao.findLoginLogTotalCountByUserId(userId);
	}
}
