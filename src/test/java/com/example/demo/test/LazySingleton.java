package com.example.demo.test;

//懒汉
public class LazySingleton {
	private LazySingleton() {

	}

	private static LazySingleton instance = null;

	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
				// return instance;
			}
		}
		return instance;
	}
}
