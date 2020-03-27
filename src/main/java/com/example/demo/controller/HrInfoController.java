/**
 * 
 */
package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.config.FastDFSUtils;
import com.example.demo.pojo.Hr;
import com.example.demo.pojo.RespBean;
import com.example.demo.service.HrService;

/**
 * @author zhangtl
 * @Time 2020年3月24日
 */
@RestController
public class HrInfoController {

	@Autowired
	HrService hrService;
	
	@Value("${fastdfs.nginx.host}")
	String nginxHost;
	
	@GetMapping("/hr/info")
	public Hr getCurrentHr(Authentication authentication) {
		return (Hr) authentication.getPrincipal();
	}
	@PutMapping("/hr/info")
	public RespBean updateHr(@RequestBody Hr hr,Authentication authentication) {
		if(hrService.updateHr(hr)==1) {
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(),authentication.getAuthorities()));
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}
	@PutMapping("/hr/pass")
	public RespBean updateHrPasswd(Map<String, Object> info) {
		String oldpass=(String) info.get("oldpass");
		String pass=(String) info.get("pass");
		Integer hrid=(Integer) info.get("hrid");
		if(hrService.updateHrPasswd(oldpass, pass, hrid)) {
			return RespBean.ok("更新成功！");
		}
		return RespBean.error("更新失败");
	}
	public RespBean updateHrUserface(MultipartFile file,Integer id,Authentication authentication) {
		String fileId=FastDFSUtils.upload(file);
		String url=nginxHost+fileId;
		if(hrService.updateUserface(url, id)==1) {
			Hr hr=(Hr) authentication.getPrincipal();
			hr.setUserface(url);
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(),authentication.getAuthorities()));
			return RespBean.ok("更新成功！",url);
		}
		return RespBean.error("更新失败！");
	}
}
