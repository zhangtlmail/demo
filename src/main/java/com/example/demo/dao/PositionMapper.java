/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Position;

/**
 * @author zhangtl
 * @Time 2020年3月22日
 */
public interface PositionMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Position record);

	int insertSelective(Position record);

	Position selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Position record);

	int updateByPrimaryKey(Position record);

	List<Position> getAllPositions();

	Integer deletePositionByIds(@Param("ids") Integer[] ids);
}
