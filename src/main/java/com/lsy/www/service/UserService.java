package com.lsy.www.service;

import java.util.List;

import com.lsy.www.db.example.User;

/**
 * <pre>
 * TODO 用户接口
 * </pre>
 * @author 梁舒艺
 * @version v1.0.0 2019年4月22日  梁舒艺 创建
 * @copyright 2019 {@link http://www.y-ke.com} All rights reserved.
 * <br>注意：本内容仅限于广州云客网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface UserService {
	
	/**
	 * 
	 * <pre>
	 * TODO 查询用户
	 * </pre>
	 * @author 梁舒艺 
	 * @return   
	 * @version v1.0.0 2019年4月22日  梁舒艺 创建
	 */
	List<User> select() throws Exception;
	
	/**
	 * 
	 * <pre>
	 * TODO 新增用户
	 * </pre>
	 * @author 梁舒艺 
	 * @param user   
	 * @version v1.0.0 2019年4月22日  梁舒艺 创建
	 */
	void insert(User user) throws Exception;

}
