package com.rz;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rz.task.AsyncThreadTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest2 {
	
	public Logger LOG = LoggerFactory.getLogger(ApplicationTest2.class);
	
	@Autowired
	AsyncThreadTask task;
	
	int joinTime = 10000; // 10s
	
	/**
	 * 异步任务全部完成--线程池
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		
		  long start = System.currentTimeMillis();
		  task.taskOne();
		  task.taskTwo();
		  task.taskThree();
		 
		  Thread.currentThread().join(joinTime);
		  TimeUnit.SECONDS.sleep(1);
		  long end = System.currentTimeMillis();
		  LOG.info("task all finished! all process time:{} ms",end-start);
		  
	}
	
	/**
	 * 模拟高并发情况下ShutDown的情况
	 * @throws Exception
	 */
	@Test
	public void testTaskRedis() throws Exception {
		
		/**
		 * 说明：
		 * 通过for循环往上面定义的线程池中提交任务，由于是异步执行，在执行过程中，利用System.exit(0)来关闭程序，
		 * 此时由于有任务在执行，就可以观察这些异步任务的销毁与Spring容器中其他资源的顺序是否安全。
		 */
		for (int i = 0; i < 10000; i++) {
            task.taskOne();
            task.taskTwo();
            task.taskThree();

            if (i == 9999) {
                System.exit(0);
            }
        }
		
		/**
		 * 
		 * 如果线程池没有设置executor.setWaitForTasksToCompleteOnShutdown(true);
		 * 和executor.setAwaitTerminationSeconds(60);时
		 * 以上并发会出现JedisConnectionException: Could not get a resource from the pool问题
		 *           
		 * 原因分析:
		 * 从异常信息JedisConnectionException: Could not get a resource from the pool来看，
		 * 我们很容易的可以想到，在应用关闭的时候异步任务还在执行，由于Redis连接池先销毁了，
		 * 导致异步任务中要访问Redis的操作就报了上面的错。所以，我们得出结论，上面的实现方式在应用关闭的时候是不优雅的
		 * 
		 * 解决方法： 
		 * 加入以上两个配置参数
		 */
		
	}

	
}
