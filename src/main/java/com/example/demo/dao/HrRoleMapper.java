/**
 * 
 */
package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.HrRole;

/**
 * @author zhangtl
 * @Time 2020年3月23日
 */
public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    void deleteByHrid(Integer hrid);

    Integer addRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}
