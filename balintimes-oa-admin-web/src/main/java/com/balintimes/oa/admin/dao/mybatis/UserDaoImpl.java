package com.balintimes.oa.admin.dao.mybatis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.balintimes.oa.admin.dao.IUserDao;
import com.balintimes.oa.admin.domain.User;
import com.balintimes.oa.admin.persistence.mybatis.mappers.UserMapper;

@Repository
public class UserDaoImpl implements IUserDao {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserMapper userMapper;

	public List<User> findAllUsers() {
		return userMapper.findAllUsers();
	}

	public User findUserById(Integer userId) {
		return userMapper.findUserById(userId);
	}

	@Transactional
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}
}
