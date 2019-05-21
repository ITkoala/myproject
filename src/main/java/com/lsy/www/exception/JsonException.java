package com.lsy.www.exception;

/**
 * <pre>
 * TODO 此处填写类描述
 * </pre>
 * 
 * @author 梁舒艺
 * @version v1.0.0 2019年4月22日 梁舒艺 创建
 * @copyright 2019 {@link http://www.y-ke.com} All rights reserved. <br>
 *            注意：本内容仅限于广州云客网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class JsonException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public JsonException(String message) {
		super(message);
	}

}
