package com.example.demo.service.imp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DutyDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Duty;
import com.example.demo.pojo.User;
import com.example.demo.service.DutyService;

@Service
public class DutyServiceImp implements DutyService {

	@Autowired
	private DutyDao dutyDao;
	@Autowired
	private UserDao userDao;

	@Override
	public Duty findDuty(int userId, Date today) {
		return dutyDao.findDuty(userId, today);
	}

	@Override
	public int saveDutyIn(String loginName) {
		// 判断用户是否已经签到
		int i = 0;// 0失败。1成功签到。2已签到
		User user = new User();
		user = userDao.findByName(loginName);// 根据登录名获取user的id信息
		Date now = new Date();// yyyyMMdd——>hhmmss
		java.sql.Date today = new java.sql.Date(now.getTime());// hhmmss，例如"2020-2-20"
		Duty duty = findDuty(user.getId(), today);
		if (duty == null) {// 今天没有签到
			DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			String signinTime = sdf.format(now);
			duty = new Duty(user.getId(), today, signinTime);
			i = dutyDao.saveDutyIn(duty);
			return i;// 1成功签到0行受影响插入失败
		} else {
			return 2;
		}
	}

	@Override
	public int saveDutyOut(String loginName) {
		// 判断用户是否已经签退
		int i = 0;// 0失败。1成功签退。2已签退
		User user = new User();
		user = userDao.findByName(loginName);// 根据登录名获取user的id信息
		Date now = new Date();// yyyyMMdd——>hhmmss
		java.sql.Date today = new java.sql.Date(now.getTime());// hhmmss，例如"2020-2-20"
		String s= findDutyOut(user.getId());
		if(s.equals("noSignOut")) {
			DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			String signoutTime = sdf.format(now);
			i=dutyDao.saveDutyOut(user.getId(), today, signoutTime);
			return i;
		}else {
			return 2;
		}
	}

	@Override
	public String findDutyOut(int userId) {
		String s=dutyDao.findDutyOut(userId);
		if(s==null) {//没有签退
			return "noSignOut";
		}else {
			return "yesSignOut";
		}
	}

	@Override
	public List<Duty> findAllDuty() {
		return dutyDao.findAllDuty();
	}

}
