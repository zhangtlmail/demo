/**
 * 
 */
package com.example.demo.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Hr;
import com.example.demo.pojo.RespBean;
import com.example.demo.pojo.Role;
import com.example.demo.service.HrService;
import com.example.demo.service.RoleService;

/**
 * @author zhangtl
 * @Time 2020年3月21日
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
	@Autowired
	HrService hrService;
	@Autowired
	RoleService roleService;
	@GetMapping("/")
	public List<Hr> getAllHrs(String keywords){
		return hrService.getAllHrs(keywords);
	}
	@PutMapping("/")
	public RespBean updateHr(Hr hr) {
		if(hrService.updateHr(hr)==1) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}
	@GetMapping("/roles")
	public List<Role> getAllroRoles(){
		return roleService.getAllRoles();
	}
	@PutMapping("/role")
	public RespBean updateHrRole(Integer hrid,Integer[] rids) {
		if(hrService.updateHrRole(hrid, rids)) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}
	@DeleteMapping("/{id}")
	public RespBean deleteHrById(@PathVariable Integer id) {
		if(hrService.deleteHrById(id)==1) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}
}
