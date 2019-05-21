package com.lsy.www.timing;

import java.util.Date;
import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class TimerManager {
		
	private Logger logger = LoggerFactory.getLogger(TimerManager.class);
	
	public TimerManager() {
		logger.info("------------定时器开始----------------");
		try {
			timerRun();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	//定时器执行方法
	private void timerRun() {
		try {
			//设置时间间隔
			int  testTIme = 1*60;
			long PERIOD_DAY = 1000;
			Date date = new Date();
			Timer timer = new Timer();
			UserTimer userTimer = new UserTimer();
			logger.info("定时任务,启动时间:" + date);
			timer.schedule(userTimer, date, PERIOD_DAY);
		}catch(Exception e) {
			e.printStackTrace();
		}
 	}
}
