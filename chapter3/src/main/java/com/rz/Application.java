package com.rz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 如需打包部署至tomcat，需继承SpringBootServletInitializer重写configure方法
 * @author 18217
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	return builder.sources(Application.class);
    }	
    
	public static void main(String[] args) {
		
		 SpringApplication.run(Application.class, args);
	}
	
}
