package com.rz.commons;

import java.util.Locale;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * WebMvcConfigurerAdapter类在spring5中已被废弃 
 * https://blog.csdn.net/lenkvin/article/details/79482205
 * @author 18217
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class LocaleConfig implements WebMvcConfigurer  {
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver(); 
		slr.setDefaultLocale(Locale.CHINA);// 默认语言
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor(); 
		lci.setParamName("lang");// 参数名
		return lci; 
	}
	
	 @Override 
	 public void  addInterceptors(InterceptorRegistry registry){
	
	    registry.addInterceptor(localeChangeInterceptor());
	    
	 }
}
