package com.ymzhu.service;

import com.ymzhu.domain.User;

/**
 * 用户接口
 * 
 * @author ymzhu
 */
public interface UserService {
	/**
	 * 通过用户名获取用户
	 * 
	 * @param username
	 * @return User
	 */
	User selectUserByUsername(String username);

}
