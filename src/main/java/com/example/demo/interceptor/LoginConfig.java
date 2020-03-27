package com.example.demo.interceptor;

//import com.example.demo.interceptor.LoginInterceptor;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class LoginConfig /*implements WebMvcConfigurer*/ {
	/**
	 * 默认访问的是首页
	 *
	 * @param registry
	 */
	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry) {
	 * registry.addViewController("/").setViewName("login");
	 * registry.addViewController("/login.html").setViewName("login");
	 * registry.addViewController("/main.html").setViewName("dashboard"); }
	 */

	/**
	 * 将static下面的js，css文件加载出来
	 *
	 * @param registry
	 */
	//@Override
	//public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/static/").addResourceLocations("classpath:/static/");
	//	registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	//}

	/**
	 * 将国际化添加到容器中
	 *
	 * @return
	 */
	/*
	 * @Bean public LocaleResolver localeResolver() { return new MyLocalResolver();
	 * }
	 */

	/**
	 * 注册拦截器
	 *
	 * @param registry
	 */
	//@Override
	//public void addInterceptors(InterceptorRegistry registry) {
	//	registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login.html",
	//			"/user/login", "/**.css", "*.js", "*.png", "*.jpg", "*.jpeg", "*.gif",
	//			"/**/fonts/*", "/**/*.svg","/loginForm","/checkUser","/register");
	//}
	
	/*
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(new LoginInterceptor()) .addPathPatterns("/**")
	 * .excludePathPatterns("/test/login"); }
	 */
}
