package com.rz.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * spring boot 1.5 以后，ConfigurationProperties取消locations属性，因此采用PropertySource注解配合使用
        根据Spring Boot2.0官方文档，PropertySource注解，只支持properties文件，因此排除 YAML配置   
 * @author 18217
 *
 */
@ConfigurationProperties(prefix="wechat")
@PropertySource(value="classpath:/wechat.properties",encoding="UTF-8")
//@PropertySources({@PropertySource("classpath:jdbcConfig.properties"),@PropertySource("file:/W:/workspace_idea/springbootreadproperty/testConfig.properties")},@PropertySource(value = "file:${config.location}"))//加载多个属性文件，file:/ 可以指定系统目录下的属性文件
//@PropertySource(value= {"classpath:/config/propConfigs.properties","classpath:/config/abc.properties"})
@Configuration
public class WechatProperties {
   
	private int id;//当prefix指定前缀时，如此名称和尾部相同，不用额外注解
	
	private static String secure;
	
	@Value("${wechat.secure}")
	private String s;

	
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public static String getSecure() {
		return secure;
	}


	// 静态使用注解   方式二
	@PostConstruct
	public void init() {
		secure=s;
	}
	/**
     * 这里需要用到注解属性中的值做一些处理
     */
    public static void hello() {
    	System.out.println("hello "+secure);
    }
	
	
}
