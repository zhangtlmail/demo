package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.MSG;

//实现 Restful HTTP 服务
@Controller
//@RequestMapping("user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	// first Page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String firstPage() {
		System.out.println("进入lr");
		return "lr";
	}

	// 注册查询用户名重复
	@RequestMapping(value = "checkUser", method = { RequestMethod.POST })
	public void checkUser(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		System.out.println("注册查询用户名重复");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("loginname");
		User user = userService.checkUser(name);
		if (user != null) {
			out.print(1);// 用户名已存在
		} else {
			out.print(0);// 用户名可以用
		}
	}

	// 注册
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(User user) {
		System.out.println("注册方法");
		System.out.println(user.toString());// 调试值显示
		// userService.register(user);
		return "lr";
	}

	/**
	 * 登录逻辑
	 * 
	 * @param name    用户名
	 * @param pwd     用户密码
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@PostMapping(value = "/loginForm")
	public void login(HttpServletResponse response,@RequestParam(value = "loginName") String loginName, @RequestParam(value = "loginPwd") String loginPwd,
			HttpServletRequest request) throws IOException {
		/*
		 * ModelAndView modelAndView =null; modelAndView=new ModelAndView();
		 * modelAndView.setViewName("hello"); modelAndView.addObject("key", 12345);
		 */
        PrintWriter out = response.getWriter();
		String info = "登录逻辑";
		logger.info(info);
		User user=null;
		user=userService.login(loginName, loginPwd);
		// 登录认证，认证成功后将用户信息放到session中
		if (user!=null) {//用户名与密码正确
			request.getSession().setAttribute("userName", user.getName());
			logger.info("用户名与密码正确");
			out.print(1);
		} else {
			logger.info("用户名与密码不正确或格式错误");
			out.print(0);
		}
	}
	//下面类的校验多参数需要相邻，一对一对的。
	public boolean validateLogin(@Validated User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                //...
            }
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            ObjectError objectError = allErrors.get(0);
            System.out.println(objectError.getDefaultMessage());
            System.out.println(objectError.getObjectName());
            System.out.println(allErrors);
            return false;
        }
        return true;
	}
	/**
	 * 登出操作
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/loginout")
	public String loginout(HttpServletRequest request) {
		String info = "登出操作";
		logger.info(info);
		HttpSession session = request.getSession();

		// 将用户信息从session中删除
		session.removeAttribute("userInfo");

		Object userInfo = session.getAttribute("userInfo");
		if (userInfo == null) {
			info = "登出成功";
		} else {
			info = "登出失败";
		}
		logger.info(info);

		return info;

	}
	//跳转首页
	@RequestMapping("bindex")
	public String index() {
		return "bindex";
	}
}
