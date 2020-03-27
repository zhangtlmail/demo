package com.example.demo.test;

public class HungrySingleton {
	/*
	 * 饿汉式--单例模式 
	 * 优点：类初始化时实例化,不存在线程安全问题,只有一个实例对象 
	 * 缺点:系统启动时,占用资源
	 */
	private HungrySingleton() {
		
	}
	
	private static HungrySingleton instance=new HungrySingleton();
	
	public static HungrySingleton getInstance() {
		return instance;
	}
}