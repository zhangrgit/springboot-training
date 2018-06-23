package com.rz.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rz.utils.WechatProperties;

@RestController
public class IndexController {

	private Logger LOG =LoggerFactory.getLogger(getClass());
	
    //装配自定义配置
	@Autowired
	WechatProperties config;
	//直接获取
	@Value("${author}")
	private String author;
	
	@Value(value="${mail}")
	private String mail;
		
	@GetMapping(value="/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping(value="/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		return "Hello, "+name;
	}
	
	@GetMapping("/config")
	public void config() {
		
		LOG.info("author->"+author);
		LOG.info("mail->"+mail);
		LOG.info("id->"+config.getId());
		LOG.info("secure->"+WechatProperties.getSecure());
	}
}
