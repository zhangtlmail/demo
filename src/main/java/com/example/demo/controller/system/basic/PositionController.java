/**
 * 
 */
package com.example.demo.controller.system.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Position;
import com.example.demo.pojo.RespBean;
import com.example.demo.service.PositionService;

/**
 * @author zhangtl
 * @Time 2020年3月21日
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
	@Autowired
	PositionService positionService;
	@GetMapping("/")
	public List<Position> getAllPositions(){
		return positionService.getAllPositions();
	}
	@PostMapping("/")
	public RespBean addposition(@RequestBody Position position) {
		if(positionService.addPosition(position)==1) {
			return RespBean.ok("添加成功");
		}
		return RespBean.error("添加失败");
	}
	@PutMapping("/")
	public RespBean updatePositions(@RequestBody Position position) {
		if(positionService.updatePositions(position)==1) {
			return RespBean.ok("更新成功！");
		}
		return RespBean.error("更新失败");
	}
	public RespBean deletePositionById(@PathVariable Integer id) {
		if(positionService.deletePositionById(id)==1) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}
	public RespBean deletePositionByIds(Integer[] ids) {
		if(positionService.deletePositionsByIds(ids)==ids.length) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}
}
