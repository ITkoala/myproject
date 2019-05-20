package com.lsy.www.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	@Test
	public void testJedisClient() {
		// 定义redis连接池
		JedisPool jedisPool = null;
		// 定义redis实例
		Jedis jedis = null;
		try {
			// 映射redis配置文件
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"classpath:applicationContext.xml");
			// 获取redis连接池
			jedisPool = (JedisPool) applicationContext.getBean("jedisPool");
			// 获取redis实例
			jedis = jedisPool.getResource();
			// 存值
			jedis.set("name", "rose");
			// 取值
			String name = jedis.get("name");
			// 输出控制台
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (jedis != null)
				jedis.close();
		}
		if (jedisPool != null) {
			jedisPool.close();
		}
	}
}
