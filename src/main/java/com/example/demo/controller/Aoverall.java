package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.pojo.Foo2;

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

	public void branch() {
		System.out.println("new hot_fix");
	}

}
