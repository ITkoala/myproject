package com.lsy.www.test;

import com.lsy.www.db.example.User;

public class ReflectTest {
	public static void main(String[] args) throws Exception {
		classforname();
	}
	
	private static void classforname() throws Exception {
		Class clazz = Class.forName("com.lsy.www.db.example.User");
		User user = (User)clazz.newInstance();
		System.err.println(user);
	}
}
