package com.lsy.www.myenum;

public enum DateFormat {
	/**
	 * 时间格式 年-月-日 yyyy-MM-dd
	 */
	YMD("yyyy-MM-dd"),
	/**
	 * 时间格式 年-月-日 yyyy-MM-dd
	 */
	YMD_CHINA("yyyy年MM月dd日"),
	/**
	 * 时间格式 年月日时分秒 yyyyMMddHHmmss
	 */
	YMDHMSSIMPLE("yyyyMMddHHmmss"),
	/**
	 * 时间格式 年月日 yyyyMMdd
	 */
	YMDSIMPLE("yyyyMMdd"),
	/**
	 * 时间格式 年-月-日 时:分:秒 "yyyy-MM-dd HH:mm:ss
	 */
	YMDHMS("yyyy-MM-dd HH:mm:ss"),
	/**
	 * 时间格式 年-月-日 时:分 "yyyy-MM-dd HH:mm
	 */
	YMDHM("yyyy-MM-dd HH:mm"),
	/**
	 * 国际化时间格式
	 */
	YMDHMST("yyyy-MM-dd'T'HH:mm:ssXXX");

	private String format;

	private DateFormat(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
