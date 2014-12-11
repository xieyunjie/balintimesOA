package com.balintimes.oa.admin.dao;

import java.util.List;

import com.balintimes.oa.admin.domain.User;

public interface IUserDao {
	List<User> findAllUsers();

	User findUserById(Integer id);

	void insertUser(User user);
}
