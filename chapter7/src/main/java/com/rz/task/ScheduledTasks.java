package com.rz.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	   private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	   private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	    /**
	     * 上一次开始执行时间点之后1秒再执行
	     */
	    @Scheduled(fixedRate = 1000)
	    public void task1() {
	    	log.info("task1 now time {}：" ,dateFormat.format(new Date()));
	    }
	    
	    /**
	     * 上一次执行完毕时间点之后1秒再执行
	     */
	    @Scheduled(fixedDelay = 1000)
	    public void task2() {
	    	log.info("task2 now time {}：" ,dateFormat.format(new Date()));
	    }
	    
	    /**
	     * 第一次延迟1秒后执行，之后按fixedRate的规则每3秒执行一次
	     */
	    @Scheduled(initialDelay = 1000,fixedDelay=3000)
	    public void task3() {
	    	log.info("task3 now time: {}" ,dateFormat.format(new Date()));
	    }
	    
	    /**
	     * cron表达式定义规则执行
	     */
	    @Scheduled(cron="*/2 * * * * *")
	    public void task4() {
	    	log.info("task4 now time {}：" ,dateFormat.format(new Date()));
	    }


}
