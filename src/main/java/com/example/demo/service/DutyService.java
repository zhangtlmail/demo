package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Duty;

public interface DutyService {
	// 查询是否签到
	public Duty findDuty(@Param("userId") int userId, @Param("today") Date today);

	// 签到或签退
	public int saveDutyIn(String loginName);

	// 签退
	public int saveDutyOut(String loginName);

	// 查询是否签退
	public String findDutyOut(@Param("userId") int userId);
	
	//查询所有
	public List<Duty> findAllDuty();
}
