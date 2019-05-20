package com.lsy.www.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.lsy.www.myenum.DateFormat;
import com.lsy.www.myenum.MessageType;
import com.lsy.www.vo.Page;
import com.lsy.www.vo.Result;
import com.lsy.www.vo.ResultVO;

/**
 * 
 * <pre>
 * TODO 封装返回信息
 * </pre>
 * @author 梁舒艺
 * @version v1.0.0 2019年5月17日  梁舒艺 创建
 * @copyright 2019 {@link http://www.y-ke.com} All rights reserved.
 * <br>注意：本内容仅限于广州云客网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class ResultManager {
	
	Logger logger = LoggerFactory.getLogger(ResultManager.class);
	
	/**
	 * 
	 * <pre>
	 * TODO 只返回信息
	 * </pre>
	 * @author 梁舒艺 
	 * @param message
	 * @return   
	 * @version v1.0.0 2019年5月17日  梁舒艺 创建
	 */
	public String resultSuccessMessage(String message) {
		return resultMessage(MessageType.SUCCESS.getCode(), message, null, null,DateFormat.YMD);
	}
	/**
	 * 
	 * <pre>
	 * TODO 返回信息和对象
	 * </pre>
	 * @author 梁舒艺 
	 * @param message
	 * @return   
	 * @version v1.0.0 2019年5月17日  梁舒艺 创建
	 */
	public String resultSuccessMessage(String message,Object data) {
		return resultMessage(MessageType.SUCCESS.getCode(), message, data, null,DateFormat.YMD);
	}
	/**
	 * 
	 * <pre>
	 * TODO 返回信息和对象和分页
	 * </pre>
	 * @author 梁舒艺 
	 * @param message
	 * @return   
	 * @version v1.0.0 2019年5月17日  梁舒艺 创建
	 */
	public String resultSuccessMessage(String message,Object data,Page page) {
		return resultMessage(MessageType.SUCCESS.getCode(), message, data, page,DateFormat.YMD);
	}
	/**
	 * 
	 * <pre>
	 * TODO 返回错误信息
	 * </pre>
	 * @author 梁舒艺 
	 * @param code
	 * @param message
	 * @param data
	 * @param page
	 * @return   
	 * @version v1.0.0 2019年5月17日  梁舒艺 创建
	 */
	public String resultErrorMessage(String code, String message,Object data,Page page) {
		return resultMessage(MessageType.FAILURE.getCode(), message, null, null,DateFormat.YMD);
	}
	/**
	 * 
	 * <pre>
	 * TODO 统一返回信息
	 * </pre>
	 * @author 梁舒艺 
	 * @param code 返回消息码
	 * @param message 返回内容
	 * @param obj 返回对象
	 * @param page 返回分页
	 * @return   
	 * @version v1.0.0 2019年5月17日  梁舒艺 创建
	 */
	public String resultMessage(String code, String message,Object data,Page page,DateFormat dateFormat) {
		
		ResultVO resultVO = new ResultVO();
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		resultVO.setResult(result);
		resultVO.setData(data);
		if(data instanceof List || data instanceof Set) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", data);
			resultVO.setData(map);
		}else {
			resultVO.setData(data);
		}
		resultVO.setPage(page);
		String json = JSONObject.toJSONString(resultVO);
		logger.info("返回数据{}", json);
		return json;
	}

}
