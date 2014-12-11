/**
 * 用户管理服务
 */
package com.balintimes.oa.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balintimes.oa.admin.dao.IUserDao;
import com.balintimes.oa.admin.domain.User;
import com.balintimes.oa.admin.persistence.mybatis.mappers.UserMapper;

@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IUserDao userDao;

	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	public User findUserById(Integer userId) {
		return userDao.findUserById(userId);
	}

	public void createUser(User user) {
		userDao.insertUser(user);
	}

}
