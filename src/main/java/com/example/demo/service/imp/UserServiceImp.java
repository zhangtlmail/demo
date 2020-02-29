package com.example.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.MD5Utils;
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	//注册
	@Override
	public int register(User user) {
		//md5加密password
		String md5=user.getPwd();
		String md5ok=MD5Utils.md5(md5);
		user.setPwd(md5ok);
		int num=userDao.register(user);
		if(num>0) {
			System.out.println("注册成功");
		}
		return num;
	}
	//注册查询重复
	@Override
	public User checkUser(String loginname) {
		return userDao.checkUser(loginname);
	}
	//登录
	@Override
	public User login(String loginName, String loginPwd) {
		
		System.out.println("输入的用户名密码是："+loginName+"-"+loginPwd);
		String md5=MD5Utils.md5(loginPwd);
		System.out.println("加密后的密码是："+md5);
		return userDao.login(loginName, md5);
	}
	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}

}
