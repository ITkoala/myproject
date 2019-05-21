package com.lsy.www.timing;

import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.lsy.www.db.example.User;
import com.lsy.www.service.UserService;

public class UserTimer extends TimerTask {
	private Logger logger = LoggerFactory.getLogger(TimerTask.class);
	private ApplicationContext ctx;
	//测试定时器
	@Override
	public void run() {
		try {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = ctx.getBean(UserService.class);
		List<User> list = userService.select();
		String string = JSONObject.toJSONString(list);
		logger.info("返回数据:{}",string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
