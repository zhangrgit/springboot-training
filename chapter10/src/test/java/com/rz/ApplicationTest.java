package com.rz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	 
	 @Autowired
	 @Qualifier("primaryJdbcTemplate")
	 private JdbcTemplate jdbcTemplate1;
	 
	 @Autowired
	 @Qualifier("secondaryJdbcTemplate")
	 private JdbcTemplate jdbcTemplate2;
	 
	 @Before
	 public void step() {
		 //清空所有用户
		 jdbcTemplate1.update("delete from jdbc_user");
		 jdbcTemplate2.update("delete from jdbc_user");
	 }
	 
	 
	 @Test
	public void testName() throws Exception {
		 
		 //往第一个数据源中插入2条数据
		 jdbcTemplate1.update("insert into jdbc_user(name,age) values(?,?)","张三",27);
		 jdbcTemplate1.update("insert into jdbc_user(name,age) values(?,?)","李四",29);
		 
		 //往第二个数据源中插入1条数据
		 jdbcTemplate2.update("insert into jdbc_user(name,age) values(?,?)","赵六",23);
		 
		 // 查询表验证，此时第一个数据源应该有2条数据
		 Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from jdbc_user", String.class));
		 
		// 查询表验证，此时第二个数据源应该有1条数据
		 Assert.assertEquals((Integer)1, jdbcTemplate2.queryForObject("select count(1) from jdbc_user", Integer.class));
		 
		 /**
		  * 常见错误: The method assertEquals(Object, Object) is ambiguous for the type Assert
		  * https://blog.csdn.net/kuaisuzhuceh/article/details/44726407
		  */
		
	}
	
}
