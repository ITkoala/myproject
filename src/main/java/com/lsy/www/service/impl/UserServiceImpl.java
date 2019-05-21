package com.lsy.www.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lsy.www.db.example.User;
import com.lsy.www.db.example.UserExample;
import com.lsy.www.db.example.UserExample.Criteria;
import com.lsy.www.db.java.UserMapper;
import com.lsy.www.exception.BusinessException;
import com.lsy.www.service.UserService;
import com.lsy.www.utils.CheckUtils;
import com.lsy.www.utils.Constant;

/**
 * <pre>
 * TODO 用户实现类
 * </pre>
 * 
 * @author 梁舒艺
 * @version v1.0.0 2019年4月22日 梁舒艺 创建
 * @copyright 2019 {@link http://www.y-ke.com} All rights reserved. <br>
 *            注意：本内容仅限于广州云客网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service
@Repository
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 
	 * <pre>
	 * TODO 查询用户
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @return
	 * @version v1.0.0 2019年4月22日 梁舒艺 创建
	 */
	@Override
	public List<User> select() {
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	/**
	 * 
	 * <pre>
	 * TODO 新增用户
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param user
	 * @version v1.0.0 2019年4月22日 梁舒艺 创建
	 * @throws Exception
	 */
	@Override
	public void insert(User user) throws Exception {
		checkInsertData(user);
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andTelEqualTo(user.getTel());
		criteria.andMarkEqualTo(Constant.MARK_Y);
		List<User> list = userMapper.selectByExample(example);
		if (null != list && !list.isEmpty()) {
			throw new BusinessException("用户已存在");
		}
		// 生成指定格式用户代码
		getUserCode(user);
		user.setCreateId(user.getUserCode());
		user.setCreateTime(new Date());
		user.setMark(Constant.MARK_Y);
		userMapper.insertSelective(user);
	}

	/**
	 * <pre>
	 * TODO 生成指定格式用户代码
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param user
	 * @version v1.0.0 2019年4月25日 梁舒艺 创建
	 */
	private void getUserCode(User user) {
		StringBuilder sb = new StringBuilder();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sed = calendar.get(Calendar.SECOND);
		sb.append(year).append(month).append(date).append(hour).append(min).append(sed);
		String userCode = sb.toString();
		user.setUserCode(userCode);
	}

	/**
	 * <pre>
	 * TODO 校验插入数据
	 * </pre>
	 * 
	 * @author 梁舒艺
	 * @param user
	 * @version v1.0.0 2019年4月25日 梁舒艺 创建
	 * @throws Exception
	 */
	private void checkInsertData(User user) throws Exception {
		if (CheckUtils.isObjNull(user)) {
			throw new BusinessException("请求对象为空");
		}
		if (CheckUtils.isNull(user.getUserName())) {
			throw new BusinessException("用户名为空");
		}
		if (CheckUtils.isNull(user.getTel())) {
			throw new BusinessException("手机号码为空");
		}
		if (CheckUtils.isNull(user.getTel())) {
			throw new BusinessException("密码为空");
		}
	}

}
