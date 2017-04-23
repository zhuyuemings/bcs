package com.ymzhu.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ymzhu.dao.UserMapper;
import com.ymzhu.domain.User;

public class UserMapperTest extends BaseTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void selectTest() {
		String username = "admin";
		User user = userMapper.selectUserByUsername(username);
		if (user != null) {
			System.out.println(user);
		}
	}
}
