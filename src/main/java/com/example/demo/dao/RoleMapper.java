/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import com.example.demo.pojo.Role;

/**
 * @author zhangtl
 * @Time 2020年3月24日
 */
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRoles();
}
