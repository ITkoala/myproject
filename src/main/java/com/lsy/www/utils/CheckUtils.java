package com.lsy.www.utils;

/**
 * 
 * <pre>
 * TODO 判断工具类
 * </pre>
 * 
 * @author 梁舒艺
 * @version v1.0.0 2019年4月25日 梁舒艺 创建
 */
public class CheckUtils {

	/**
	 * <pre>
	 * TODO 校验字符串是否为空
	 * </pre>
	 * @author 梁舒艺
	 * @param str
	 * @return
	 * @version v1.0.0 2019年4月25日 梁舒艺 创建
	 */
	public static boolean isNull(String str) {
		if (null == str || "" == str) {
			return true;
		}
		return false;
	}
	/**
	 * <pre>
	 * TODO 校验对象是否为空
	 * </pre>
	 * @author 梁舒艺
	 * @param str
	 * @return
	 * @version v1.0.0 2019年4月25日 梁舒艺 创建
	 */
	public static boolean isObjNull(Object obj) {
		if (null == obj) {
			return true;
		}
		return false;
	}
	
}
