package com.rz.task;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
	
	public Random random = new Random();
	
	public Logger LOG = LoggerFactory.getLogger(AsyncTask.class);
	
	/**
	 * @Async所修饰的函数不能定义为static类型,否异步调用不会生效
	 * @throws InterruptedException
	 */
	@Async
	public Future<String> taskOne() throws InterruptedException {
		LOG.info("task1 start... ");
		long start = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(random.nextInt(10));
		long end = System.currentTimeMillis();
		LOG.info("task1 finish! process time:{} ms",end-start);
		return new AsyncResult<String>("task1 finish!");
	}
	
	@Async
	public Future<String> taskTwo() throws InterruptedException {
		LOG.info("task2 start... ");
		long start = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(random.nextInt(10));
		long end = System.currentTimeMillis();
		LOG.info("task2 finish! process time:{} ms",end-start);
		return new AsyncResult<String>("task2 finish!");
	}
	
	@Async
	public Future<String> taskThree() throws InterruptedException {
		LOG.info("task3 start... ");
		long start = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(random.nextInt(10));
		long end = System.currentTimeMillis();
		LOG.info("task3 finish! process time:{} ms",end-start);
		return new AsyncResult<String>("task3 finish!");
	}

}
