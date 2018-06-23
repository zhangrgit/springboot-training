package com.rz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rz.utils.SysProperties;
import com.rz.utils.WechatProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	private Logger LOG =LoggerFactory.getLogger(getClass());
	
	//装配自定义配置
	@Autowired
	WechatProperties config;
	
	//装配系统默认配置
	@Autowired
	SysProperties sysProperties;
	
	//直接获取
	@Value("${author}")
	private String author;
	
	@Value(value="${mail}")
	private String mail;
	
	@Test
	public void testName() throws Exception {
		
//		☆☆☆   以下四条LOG输出写法 xx,yy无法正确输出，改为单参数可以 
//		LOG.info("author->",author);
//		LOG.info("mail->",mail);
//		LOG.info("id->",config.getId());
//		LOG.info("secure->",config.getSecure());
		
		LOG.info("author->"+author);
		LOG.info("mail->"+mail);
		LOG.info("id->"+config.getId());
		LOG.info("secure->"+WechatProperties.getSecure());
		
		
//		Assert.assertEquals("如", sysProperties.getName());
//		Assert.assertEquals("Spring Boot教程", sysProperties.getTest1());
//		Assert.assertEquals("如正在努力写《Spring Boot教程》", sysProperties.getDesc());
		
		
		LOG.info("随机字符串:"+sysProperties.getValue());
		LOG.info("随机int : " + sysProperties.getNumber());
		LOG.info("随机long : " + sysProperties.getBignumber());
		LOG.info("随机10以下 : " + sysProperties.getTest1());
		LOG.info("随机10-20 : " + sysProperties.getTest2());
		
		
		WechatProperties.hello();
		config.hello();
		SysProperties.hello();
		
		
	}
	
	
	
}
