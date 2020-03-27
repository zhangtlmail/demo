/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MenuMapper;
import com.example.demo.dao.MenuRoleMapper;
import com.example.demo.pojo.Hr;
import com.example.demo.pojo.Menu;

/**
 * @author zhangtl
 * @Time 2020年3月23日
 */
@Service
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	MenuRoleMapper menuRoleMapper;


	public List<Menu> getMenusByHrId() {
		return menuMapper
				.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
	}

	@Cacheable
	public List<Menu> getAllMenusWithRole() {
		return menuMapper.getAllMenusWithRole();
	}

	public List<Menu> getAllMenus() {
		return menuMapper.getAllMenus();
	}

	public List<Integer> getMidsByRid(Integer rid) {
		return menuMapper.getMidsByRid(rid);
	}

	public boolean updateMenuRole(Integer rid, Integer[] mids) {
		menuRoleMapper.deleteByRid(rid);
		if (mids == null || mids.length == 0) {
			return true;
		}
		Integer result = menuRoleMapper.insertRecord(rid, mids);
		return result == mids.length;
	}
}
