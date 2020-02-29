package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.pojo.Duty;
import com.example.demo.service.DutyService;

@Controller
public class DutyController {
	@Autowired
	private DutyService dutyService;

	// 考勤签到操作
	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public void signin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取session作用域中的emp对象，emp存放的是被考勤人信息，自行创建
		String userName = (String) request.getSession().getAttribute("userName");
		int result = dutyService.saveDutyIn(userName);
		// 无需页面跳转，直接响应结果（通常与ajax连用）
		response.getWriter().println(result);
	}

	// 考勤签到操作
	@RequestMapping(value = "signout", method = RequestMethod.POST)
	public void signout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = (String) request.getSession().getAttribute("userName");
		int result = dutyService.saveDutyOut(userName);
		System.out.println("返回结果"+result);
		response.getWriter().println(result);
	}
	
	@RequestMapping(value = "battendance",method = RequestMethod.GET)
	public String goToAttendance(Model model) {
		List<Duty> dutyAll=new ArrayList<Duty>();
		dutyAll=dutyService.findAllDuty();
		model.addAttribute("dutyAll",dutyAll);
		return "battendance";
	}
}
