package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Duty;

public interface DutyDao {
	//查询是否签到
	public Duty findDuty(@Param("userId") int userId, @Param("today") Date today);
	//签到
	public int saveDutyIn(Duty duty);
	//签退
	public int saveDutyOut(@Param("userId") int userId, @Param("today") Date today,@Param("signoutTime") String signoutTime);
	//查询是否签退
	public String findDutyOut(@Param("userId") int userId);
	
	/*
	 * @Insert("insert into tb_user(name,sex) values(#{name},#{sex})") public void
	 * insertT(User user);
	 * 
	 * @Delete("delete from tb_user where id=#{id}") public void deleteById(int id);
	 * 
	 * @Update("update tb_user set name=#{name},sex=#{sex} where id=#{id}") public
	 * void updateT(User user);
	 * 
	 * @Select("select * from tb_user where id=#{id}") public User getUser(int id);
	 * 
	 * @Select("select * from tb_user") public List<User> getAllUsers();
	 */
	//查询所有
	public List<Duty> findAllDuty();
		
}
