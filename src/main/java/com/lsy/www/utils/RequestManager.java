package com.lsy.www.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lsy.www.exception.BusinessException;
import com.lsy.www.myenum.DateFormat;

public class RequestManager {
	// 打印日志
	private Logger logger = LoggerFactory.getLogger(RequestManager.class);

	public static final String DATA_KEY = "data";

	private Gson gson;

	private JSONObject jsonObject;

	/**
	 * 
	 * <pre>
	 * TODO gson+JSONObject
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param str
	 * @param clazz
	 * @return
	 * @throws Exception
	 * @version v1.0.0 2019年5月17日 梁舒艺 创建
	 */
	public <T> T parseString(String str, Class<T> clazz) throws Exception {
		if (CheckUtils.isNull(str)) {
			throw new BusinessException("请求参数为空");
		}
		if (gson == null) {
			gson = new GsonBuilder().setDateFormat(DateFormat.YMD.getFormat()).create();
		}
		jsonObject = JSONObject.parseObject(str);
		logger.info("请求参数{}", jsonObject);
		if (jsonObject == null) {
			throw new JSONException("json数据为空");
		}
		return gson.fromJson(jsonObject.getString(RequestManager.DATA_KEY), clazz);
	}

	/**
	 * 
	 * <pre>
	 * TODO JSONObeject
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param str
	 * @param clazz
	 * @return
	 * @throws Exception
	 * @version v1.0.0 2019年5月17日 梁舒艺 创建
	 */
	public <T> T parseJsonString(String str, Class<T> clazz) throws Exception {
		if (CheckUtils.isNull(str)) {
			throw new BusinessException("请求参数为空");
		}
		// 将json字符串转换为json对象
		jsonObject = JSONObject.parseObject(str);
		logger.info("请求参数{}", jsonObject);
		if (jsonObject == null) {
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
	 * 
	 * @author 梁舒艺
	 * @param str
	 * @param clazz
	 * @return
	 * @throws Exception
	 * @version v1.0.0 2019年5月17日 梁舒艺 创建
	 */
	public <T> T parseRequest(String str, Class<T> clazz) throws Exception {
		if (CheckUtils.isNull(str)) {
			throw new BusinessException("请求参数为空");
		}
		// 将json字符串转换为json对象
		jsonObject = JSONObject.parseObject(str);
		logger.info("请求参数{}", jsonObject);
		if (jsonObject == null) {
			throw new JSONException("json数据为空");
		}
		T t = JSONObject.parseObject(jsonObject.getString(RequestManager.DATA_KEY), clazz);
		return t;
	}

	/**
	 * <pre>
	 * TODO 解析请求参数request
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param request
	 * @return
	 * @throws Exception
	 * @version v1.0.0 2019年5月21日 梁舒艺 创建
	 */
	public RequestManager load(HttpServletRequest request) throws Exception {
		String reqeustStr = requestString(request);
		if (CheckUtils.isNull(reqeustStr)) {
			throw new BusinessException("请求数据为空");
		}

		load(reqeustStr);
		return null;

	}

	/**
	 * 
	 * <pre>
	 * TODO 加载请求数据
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param reqeustStr
	 * @version v1.0.0 2019年5月21日 梁舒艺 创建
	 * @throws Exception
	 */
	private RequestManager load(String reqeustStr) throws Exception {
		return load(reqeustStr, DateFormat.YMD);
	}

	/**
	 * <pre>
	 * TODO 加载请求数据,并解析
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param reqeustStr
	 * @param ymd
	 * @return
	 * @version v1.0.0 2019年5月21日 梁舒艺 创建
	 * @throws Exception
	 */
	private RequestManager load(String reqeustStr, DateFormat dateFormat) throws Exception {
		if (gson == null || null != dateFormat) {
			gson = new GsonBuilder().setDateFormat(dateFormat.getFormat()).create();
		}
		jsonObject = JSONObject.parseObject(reqeustStr);
		if (jsonObject == null) {
			throw new BusinessException("json数据为空");
		}

		return this;
	}

	/**
	 * <pre>
	 * TODO 请求参数解析类型
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param request
	 * @return
	 * @throws Exception
	 * @version v1.0.0 2019年5月21日 梁舒艺 创建
	 */
	private String requestString(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		// try(){},不用close(),自动关闭资源
		try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));) {
			String line = "";
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			String requestString = sb.toString();
			// 如果不在流中
			if (CheckUtils.isNull(requestString)) {
				// 获取路径上的参数
				requestString = request.getQueryString();
				requestString = java.net.URLDecoder.decode(requestString, "utf-8");
			}
//			String userCode="";
//			SessionBean session = (SessionBean) request.getSession().getAttribute(Constants.SESSION_APP_USER);
//			WebSession webSession=null;
//			if(null == session){
//				webSession = (WebSession) request.getSession().getAttribute(Constants.SESSION_WEB_USER);	
//			    if(null != webSession ){
//			    	userCode=webSession.getUserCode();
//			    }
//			}else{
//				userCode=session.getUserCode();
//			}
			logger.info("请求参数:{}", requestString);
//			logger.info("用户账号:{}",userCode);
			return requestString;
		} catch (Exception e) {
			logger.error("解析参数:{}", e);
		}
		return null;
	}

	public <T> T getClass(Class<T> clazz) throws Exception {
		return getClass(RequestManager.DATA_KEY, clazz);

	}

	public <T> T getClass(String key, Class<T> clazz) throws Exception {
		if (jsonObject == null) {
			throw new BusinessException("json对象为空");
		}
		if (CheckUtils.isNull(key)) {
			throw new BusinessException("节点为空");
		}
		if (jsonObject.containsKey(key)) {
			return gson.fromJson(jsonObject.getString(key), clazz);
		}
		return null;
	}
}
