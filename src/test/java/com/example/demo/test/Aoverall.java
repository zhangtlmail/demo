package com.example.demo.test;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Aoverall {
	public String drink(@Validated({ Foo2.Adult.class }) Foo2 foo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				// ...
			}
			return "fail";
		}
		return "success";
	}

	public String live(@Validated Foo2 foo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				// ...
			}
			return "fail";
		}
		return "success";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();// yyyyMMdd——>hhmmss
		java.sql.Date today = new java.sql.Date(now.getTime());// hhmmss
		System.out.println(today);
	}
}
