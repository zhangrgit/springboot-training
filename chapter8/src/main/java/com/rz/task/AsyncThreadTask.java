package com.rz.task;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncThreadTask {
	
	public Random random = new Random();
	
	public Logger LOG = LoggerFactory.getLogger(AsyncThreadTask.class);
	
//    @Autowired
//	private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * @Async所修饰的函数不能定义为static类型,否异步调用不会生效
	 * @throws InterruptedException
	 */
	@Async("taskExecutor")
	public void taskOne() throws InterruptedException {
		LOG.info("task1 start... ");
		long start = System.currentTimeMillis();
//		LOG.info(stringRedisTemplate.randomKey());
		TimeUnit.SECONDS.sleep(random.nextInt(10));
		long end = System.currentTimeMillis();
		LOG.info("task1 finish! process time:{} ms",end-start);
	}
	
	@Async("taskExecutor")
	public void taskTwo() throws InterruptedException {
		LOG.info("task2 start... ");
		long start = System.currentTimeMillis();
//		LOG.info(stringRedisTemplate.randomKey());
		TimeUnit.SECONDS.sleep(random.nextInt(10));
		long end = System.currentTimeMillis();
		LOG.info("task2 finish! process time:{} ms",end-start);
	}
	
	@Async("taskExecutor")
	public void taskThree() throws InterruptedException {
		LOG.info("task3 start... ");
		long start = System.currentTimeMillis();
//		LOG.info(stringRedisTemplate.randomKey());
		TimeUnit.SECONDS.sleep(random.nextInt(10));
		long end = System.currentTimeMillis();
		LOG.info("task3 finish! process time:{} ms",end-start);
	}

}
