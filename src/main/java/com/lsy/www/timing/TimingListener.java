package com.lsy.www.timing;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * <pre>
 * TODO 定时器
 * </pre>
 * @author 梁舒艺
 * @version v1.0.0 2019年5月16日  梁舒艺 创建
 * @copyright 2019 {@link http://www.y-ke.com} All rights reserved.
 * <br>注意：本内容仅限于广州云客网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TimingListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		new TimerManager();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
