/**
 * 
 */
package com.example.demo.service.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.pojo.Hr;

/**
 * @author zhangtl
 * @Time 2020年3月23日
 */
public class HrUtils {
	public static Hr getCurrentHr() {
		return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
