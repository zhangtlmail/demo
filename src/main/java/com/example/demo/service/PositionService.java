/**
 * 
 */
package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PositionMapper;
import com.example.demo.pojo.Position;

/**
 * @author zhangtl
 * @Time 2020年3月22日
 */
@Service
public class PositionService {
	@Autowired
	PositionMapper positionMapper;
	public List<Position> getAllPositions(){
		return positionMapper.getAllPositions();
	}
	public Integer addPosition(Position position) {
		position.setEnabled(true);
		position.setCreateDate(new Date());
		return positionMapper.insertSelective(position);
	}
	public Integer updatePositions(Position position) {
		return positionMapper.updateByPrimaryKeySelective(position);
	}
	public Integer deletePositionById(Integer id) {
		return positionMapper.deleteByPrimaryKey(id);
	}
	public Integer deletePositionsByIds(Integer[] ids) {
		return positionMapper.deletePositionByIds(ids);
	}
}
