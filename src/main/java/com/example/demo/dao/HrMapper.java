/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Hr;
import com.example.demo.pojo.Role;

/**
 * @author zhangtl
 * @Time 2020年3月22日
 */
public interface HrMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Hr record);

	int insertSelective(Hr record);

	Hr selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Hr record);

	int updateByPrimaryKey(Hr record);

	Hr loadUserByUsername(String username);

	List<Role> getHrRolesById(Integer id);

	List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

	List<Hr> getAllHrsExceptCurrentHr(Integer id);

	Integer updatePasswd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

	Integer updateUserface(@Param("url") String url, @Param("id") Integer id);
}
