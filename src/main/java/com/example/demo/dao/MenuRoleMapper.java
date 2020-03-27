/**
 * 
 */
package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.MenuRole;

/**
 * @author zhangtl
 * @Time 2020年3月23日
 */
public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    void deleteByRid(Integer rid);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
