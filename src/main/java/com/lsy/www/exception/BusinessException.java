package com.lsy.www.exception;

/**
 * <pre>
 * TODO 此处填写类描述
 * </pre>
 * 
 * @author 梁舒艺
 * @version v1.0.0 2019年4月22日 梁舒艺 创建
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String message) {
		super(message);
	}

}
