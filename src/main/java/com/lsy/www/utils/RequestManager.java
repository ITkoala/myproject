package com.lsy.www.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lsy.www.exception.BusinessException;

public class RequestManager {
	//打印日志
	private Logger logger = LoggerFactory.getLogger(RequestManager.class);
	
	public static final String DATA_KEY = "data";
	
	private Gson gson ;
	
	private JSONObject jsonObject ;
	/**
	 * 
	 * <pre>
	 * TODO gson+JSONObject
	 * </pre>
	 * @author 梁舒艺 
	 * @param str
	 * @param clazz
	 * @return
	 * @throws Exception   
	 * @version v1.0.0 2019年5月17日  梁舒艺 创建
	 */
	public <T> T  parseString(String str,Class<T> clazz) throws Exception{
		if(CheckUtils.isNull(str)) {
			throw new BusinessException("请求参数为空");
		}
		if(gson == null) {
			gson = new GsonBuilder().create();
		}
		jsonObject = JSONObject.parseObject(str);
		logger.info("请求参数{}",jsonObject);
		if(jsonObject == null) {
			throw new JSONException("json数据为空");
		}
		T t = gson.fromJson(jsonObject.getString(RequestManager.DATA_KEY), clazz);
		return t;
		
	}
	/**
	 * 
	 * <pre>
	 * TODO JSONObeject
	 * </pre>
	 * @author 梁舒艺 
	 * @param str
	 * @param clazz
	 * @return
	 * @throws Exception   
	 * @version v1.0.0 2019年5月17日  梁舒艺 创建
	 */
	public <T> T  parseJsonString(String str,Class<T> clazz) throws Exception{
		if(CheckUtils.isNull(str)) {
			throw new BusinessException("请求参数为空");
		}
		//将json字符串转换为json对象
		jsonObject = JSONObject.parseObject(str);
		logger.info("请求参数{}",jsonObject);
		if(jsonObject == null) {
			throw new JSONException("json数据为空");
		}
		T t = JSONObject.parseObject(jsonObject.getString(RequestManager.DATA_KEY), clazz);
		return t;
	}
	/**
	 * 
	 * <pre>
	 * TODO 解析流获取对象
	 * </pre>
	 * @author 梁舒艺 
	 * @param str
	 * @param clazz
	 * @return
	 * @throws Exception   
	 * @version v1.0.0 2019年5月17日  梁舒艺 创建
	 */
	public <T> T  parseRequest(String str,Class<T> clazz) throws Exception{
		if(CheckUtils.isNull(str)) {
			throw new BusinessException("请求参数为空");
		}
		//将json字符串转换为json对象
		jsonObject = JSONObject.parseObject(str);
		logger.info("请求参数{}",jsonObject);
		if(jsonObject == null) {
			throw new JSONException("json数据为空");
		}
		T t = JSONObject.parseObject(jsonObject.getString(RequestManager.DATA_KEY), clazz);
		return t;
	}
}
