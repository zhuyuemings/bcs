package com.ymzhu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ymzhu.dao.UserMapper;
import com.ymzhu.domain.User;
import com.ymzhu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper; 

	@Override
	public User selectUserByUsername(String username) {
		return userMapper.selectUserByUsername(username);
	}
}
