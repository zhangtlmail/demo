package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageForwarding {

	@RequestMapping("bfinance")
	public String bfinance() {
		return "bfinance.html";
	}
}
