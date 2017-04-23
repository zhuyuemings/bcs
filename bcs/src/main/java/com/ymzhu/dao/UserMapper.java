package com.ymzhu.dao;

import org.apache.ibatis.annotations.Param;

import com.ymzhu.domain.User;

/**
 * 用户Mapper
 * @author ymzhu
 */
public interface UserMapper {
	User selectUserByUsername(@Param("username") String username);
}
