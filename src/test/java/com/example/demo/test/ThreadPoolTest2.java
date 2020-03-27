package com.example.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


class Number implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if(i%2==0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
	
}
class Number2 implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if(i%2!=0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
	
}
public class ThreadPoolTest2 {
	public static void main(String[] args) {
		//提供指定数量的线程池
		ExecutorService service = Executors.newFixedThreadPool(10);
		ThreadPoolExecutor threadPoolExecutor=(ThreadPoolExecutor) service;
		threadPoolExecutor.setCorePoolSize(15);
		//threadPoolExecutor.setKeepAliveTime(time, unit);
		//System.out.println(service.getClass());
		service.execute(new Number());//适用于Runnable
		service.execute(new Number2());//适用于Runnable
		//service.submit(task);//适用于Callable
		service.shutdown();
	}

}
