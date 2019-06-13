package com.lsy.www.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lsy.www.db.example.User;
import com.lsy.www.service.UserService;
import com.lsy.www.utils.RequestManager;
import com.lsy.www.utils.ResultManager;

@Controller
@RequestMapping("/user/*")
public class UserController {
	/**
	 * 日志输出
	 */
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	private Gson gson = new GsonBuilder().create();
	/**
	 * 返回结果管理器
	 */
	@Autowired
	private ResultManager resultManager;
	/**
	 * 接收请求管理器
	 */
	@Autowired
	RequestManager requestManager;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/select", produces = "plain/text; charset=UTF-8")
	@ResponseBody
	public String select() {
		logger.info("------------查询用户开始--------------------");
		try {
			List<User> list = userService.select();
//			String json = gson.toJson(list);
			return resultManager.resultSuccessMessage("查询成功",list);
		} catch (Exception e) {
			logger.error("查询失败:" + e);
			e.printStackTrace();
		}
		return resultManager.resultError();
	}

	@RequestMapping(value = "/insert", produces = "plain/text; charset=UTF-8")
	@ResponseBody
	public String insert(@RequestBody String message) {
		logger.info("------------新增用户开始--------------------");
		try {
			logger.info(message);
//			User user = (User)parseRequestObject.parseString(message, User.class);
			User user = (User)requestManager.parseJsonString(message, User.class);
			userService.insert(user);
			return resultManager.resultSuccessMessage("新增成功");
		} catch (Exception e) {
			logger.error("新增失败:" + e);
			e.printStackTrace();
		}
		return resultManager.resultError();
	}

}
