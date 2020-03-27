/**
 * 
 */
package com.example.demo.controller.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.example.demo.pojo.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhangtl
 * @Time 2020年3月23日
 */
@Component
public class VerificationCodeFilter extends GenericFilter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse) response;
		if("POST".equals(req.getMethod())&&"/doLogin".equals(req.getServletPath())) {
			//登录请求
			String code=req.getParameter("code");
			String verfy_code=(String) req.getSession().getAttribute("verify_code");
			if(code==null||verfy_code==null||"".equals(code)||!verfy_code.toLowerCase().equals(code.toLowerCase())) {
				//验证码不正确
				resp.setContentType("application/json;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.write(new ObjectMapper().writeValueAsString(RespBean.error("验证码填写错误")));
				out.flush();
				out.close();
				return;
			}else {
				chain.doFilter(req, resp);
			}
		}else {
			chain.doFilter(req, resp);
		}
	}

}
