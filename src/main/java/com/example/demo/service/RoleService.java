/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleMapper;
import com.example.demo.pojo.Role;

/**
 * @author zhangtl
 * @Time 2020年3月24日
 */
@Service
public class RoleService {

	@Autowired
	RoleMapper roleMapper;
	
	public List<Role> getAllRoles(){
		return roleMapper.getAllRoles();
	}
	public Integer addRole(Role role) {
		if(!role.getName().startsWith("ROLE_")) {
			role.setName("ROLE_"+role.getName());
		}
		return roleMapper.insert(role);
	}
	public Integer deleteRoleById(Integer rid) {
		return roleMapper.deleteByPrimaryKey(rid);
	}
}
