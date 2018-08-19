package com.rz;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rz.task.AsyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	public Logger LOG = LoggerFactory.getLogger(ApplicationTest.class);
	
	@Autowired
	AsyncTask task;
	
	int timeout = 10; // unit: s
	
	/**
	 * 异步任务全部完成
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		
//		  task.taskOne();
//		  task.taskTwo();
//		  task.taskThree();
		
		  long start = System.currentTimeMillis();
		  Future<String> task1 = task.taskOne();
		  Future<String> task2 = task.taskTwo();
		  Future<String> task3 = task.taskThree();
		  
		  while (true) {
			  if(task1.isDone() && task2.isDone() && task3.isDone()) {
				  break;//三个任务都已完成，退出
			  }
		  }
		  
		  TimeUnit.SECONDS.sleep(1);
		  long end = System.currentTimeMillis();
		  LOG.info("task all finished! all process time:{} ms",end-start);
		  
	}
	
	/**
	 * 超时测试
	 */
	@Test
	public void testFutureTimeOut() {
		
		Future<String> futureResult;
		try {
			futureResult = task.taskOne();
			String result = futureResult.get(timeout, TimeUnit.SECONDS);
			LOG.info("result:{}",result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
