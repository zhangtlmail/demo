/**
 * 
 */
package com.example.demo.controller.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.example.demo.pojo.Menu;
import com.example.demo.pojo.Role;
import com.example.demo.service.MenuService;

/**
 * @author zhangtl
 * @Time 2020年3月23日
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	MenuService menuService;
	AntPathMatcher antPathMatcher=new AntPathMatcher();
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl=((FilterInvocation)object).getRequestUrl();
		List<Menu> menus=menuService.getAllMenusWithRole();
		for (Menu menu:menus) {
			if(antPathMatcher.match(menu.getUrl(), requestUrl)) {
				List<Role>roles=menu.getRoles();
				String[]str=new String[roles.size()];
				for (int i = 0; i < roles.size(); i++) {
					str[i]=roles.get(i).getName();
				}
				for (String item : str) {
					System.out.println(item);
				}
				return SecurityConfig.createList(str);
			}
		}
		return SecurityConfig.createList("ROLE_LOGIN");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
