package com.rz;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rz.domain.User;
import com.rz.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	

	 @Autowired
	 private UserService userService;
	 
	 @Before
	 public void step() {
		 //清空所有用户
		 userService.deleteAllUsers();
	 }
	 
	 
	 @Test
	public void testName() throws Exception {
		 
		 //插入五个用户
		 userService.create(new User("张三",22));
		 userService.create(new User("李四",23));
		 userService.create(new User("王五",24));
		 userService.create(new User("赵六",25));
		 userService.create(new User("小七",26));
		 
		 // 查询表验证，此时应该5个用户
		 Assert.assertEquals(5, userService.getAllUsers());
		 
		 // 删除三个用户
//		 userService.deleteById(1);
		 userService.deleteByName("张三");
		 userService.deleteByName("王五");
		 userService.deleteByName("赵六");
		 
		 //查询表验证，此时应该2个用户
		 Assert.assertEquals(2, userService.getAllUsers());
		 System.out.println(userService.getUserList());
		 
		
	}
	
}
