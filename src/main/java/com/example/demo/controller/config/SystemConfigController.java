/**
 * 
 */
package com.example.demo.controller.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Menu;
import com.example.demo.service.MenuService;

/**
 * @author zhangtl
 * @Time 2020年3月24日
 */
@RestController
@RequestMapping("system/config")
public class SystemConfigController {

	@Autowired
	MenuService menuService;
	@GetMapping("menu")
	public List<Menu> getMenusByHrId(){
		return menuService.getMenusByHrId();
	}
}
