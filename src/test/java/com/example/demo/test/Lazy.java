package com.example.demo.test;

import java.io.Serializable;

public class Lazy implements Serializable{

	/*
	 * 设置默认版本号
	 */
	private static final long serialVersionUID=1L;
	
	//volative禁止指令重排，volatile英[ˈvɒlətaɪl]创建多个对象-------》涉及到原子性操作问题
	private static volatile Lazy lazy=null;
	//volatile是一种轻量级的同步机制，它主要有两个特性：一是保证共享变量对所有线程的可见性；
	//二是禁止指令重排序优化。
	//设置标志位，如果对象已经被创建就修改标志位，在一定程度上防止反射创建对象
	private static boolean flag=false;
	
	//定义私有的构造方法
	private Lazy() {
		//单例防反射，此处还是存在问题的，对象在没有创建出来之前，还是可以通过反射创建对象
		//--------->涉及到反射的知识
		if(flag==false) {
			flag=true;
		}else {
			throw new RuntimeException("单例模式被破坏");
		}
	}
	//供外获取对象
	public static Lazy getInstance() {
		//进行双重检查，提高效率
		if(lazy==null) {
			//防止并发，使用同步代码块---------->涉及到并发问题，同步问题
			synchronized (Lazy.class) {
				if(lazy==null) {
					lazy=new Lazy();
				}
			}
		}
		return lazy;
	}
	//防序列化----》涉及到序列化问题
	public Object readResolve() {
		return lazy;
	}
}
