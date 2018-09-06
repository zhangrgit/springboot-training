package com.rz;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rz.domain.LogFileName;
import com.rz.utils.LoggerUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	 Logger XJK_USER_LOG = LoggerUtils.Logger(LogFileName.XJK_USER);
	 Logger BAITIAO_USER_LOG = LoggerUtils.Logger(LogFileName.BAITIAO_USER);
	
	@Test
	public void testName() throws Exception {
		  
		
		  XJK_USER_LOG.info("小金库用户进来了...");
	      BAITIAO_USER_LOG.info("白条用户进来了...");
		
	}
	
}
