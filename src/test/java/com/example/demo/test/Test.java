package com.example.demo.test;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now=new Date();//yyyyMMdd——>hhmmss
		java.sql.Date today=new java.sql.Date(now.getTime());//hhmmss
		System.out.println(today);
	}

}
