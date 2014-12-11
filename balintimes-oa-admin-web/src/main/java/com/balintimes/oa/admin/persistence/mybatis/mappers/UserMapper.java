package com.balintimes.oa.admin.persistence.mybatis.mappers;

import java.util.List;

import com.balintimes.oa.admin.domain.User;

public interface UserMapper {
	List<User> findAllUsers();

	User findUserById(Integer id);

	void insertUser(User user);
}
