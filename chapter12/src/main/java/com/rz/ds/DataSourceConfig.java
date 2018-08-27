package com.rz.ds;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {
	
	    @Bean(name = "primaryDataSource")
	    @Qualifier("primaryDataSource")
	    @Primary // 双数据源时告知Spring默认加载项。
	    @ConfigurationProperties(prefix="spring.datasource.primary")
	    public DataSource primaryDataSource() {
//	        return DataSourceBuilder.create().build(); // default first hikari DataSource
	    	return new DruidDataSource(); 
	    }

	    @Bean(name = "secondaryDataSource")
	    @Qualifier("secondaryDataSource")
	    @ConfigurationProperties(prefix="spring.datasource.secondary")
	    public DataSource secondaryDataSource() {
//	        return DataSourceBuilder.create().build();
	    	return new DruidDataSource(); 
	    }
	    
	    

}
