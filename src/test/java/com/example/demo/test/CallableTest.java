package com.example.demo.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*
 * call()可以有返回值
 * call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * callable支持泛型
 */
class NumberThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Integer sum=0;
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
			sum+=i;
		}
		return sum;
	}
	
}
public class CallableTest{
	public static void main(String[] args) {
		NumberThread numberThread=new NumberThread();
		FutureTask<Integer> futureTask=new FutureTask<Integer>(numberThread);
		new Thread(futureTask).start();
		try {//返回值
			Integer sum=futureTask.get();
			System.out.println("总和为："+sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
