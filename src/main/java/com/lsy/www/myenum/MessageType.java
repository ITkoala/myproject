package com.lsy.www.myenum;

public enum MessageType {
	FAILURE("0", "系统内部错误"),
	SUCCESS("1", "操作成功"),
	OVER_TIME("-100", "登录超时,请重新登录！"),
	NO_PERMISSION("-101", "权限不足,请联系管理员");

	private String code;
	private String message;

	MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
