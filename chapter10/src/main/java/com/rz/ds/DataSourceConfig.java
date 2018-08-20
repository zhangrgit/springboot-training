package com.rz.ds;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {
	
	@Bean("primaryDataSource")
//	@Qualifier("primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.primary")
	
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("secondaryDataSource")
//	@Qualifier("secondaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean(name="primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource) {
		
		 return new JdbcTemplate(dataSource);
	}
	
	@Bean(name="secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource")DataSource dataSource) {
		
		 return new JdbcTemplate(dataSource);
	}
	

}