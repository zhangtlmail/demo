package com.example.demo.service;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.User;

public interface UserService {
	// 注册查重复
	User checkUser(@Param("loginname") String loginname);
	// 注册
	int register(User user);
	//登录
	User login(@Param("loginName") String loginName,@Param("loginPwd") String loginPwd);

	//根据name查询id
	User findByName(@Param("loginName") String name);
}
