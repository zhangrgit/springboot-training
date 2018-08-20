package com.rz.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskPoolConfig {
	
	@Bean("taskExecutor")
	public Executor taskExecutor() {
		
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);//核心线程数10：线程池创建时候初始化的线程数
		executor.setMaxPoolSize(20);//最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
		executor.setQueueCapacity(500); //缓冲队列500：用来缓冲执行任务的队列
		executor.setKeepAliveSeconds(80); //允许线程的空闲时间80秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
//		设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean，这样这些异步任务的销毁就会先于Redis线程池(如果任务中有用到redis时)的销毁。
		executor.setWaitForTasksToCompleteOnShutdown(true);
//		该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
		executor.setAwaitTerminationSeconds(60);
		executor.setThreadNamePrefix("taskExecutor-"); // 程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
//		线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}

}