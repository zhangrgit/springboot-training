package com.rz;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rz.domain.User;
import com.rz.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testName() throws Exception {
		
		/**
		 * 加入5条数据
		 */
		userRepository.save(new User("张三", 22));
		userRepository.save(new User("李四", 23));
		userRepository.save(new User("王五", 24));
		userRepository.save(new User("赵六", 25));
		userRepository.save(new User("小七", 26));
		
		Assert.assertEquals(5, userRepository.findAll().size());
		
		Assert.assertEquals(23, userRepository.findUser("李四").getAge());
		
		Assert.assertEquals(24, userRepository.findByName("王五").getAge());
		
		Assert.assertEquals(26, userRepository.findByNameAndAge("小七",26).getAge());
		
		userRepository.delete(userRepository.findByName("小七"));
		
		Assert.assertEquals(4, userRepository.findAll().size());
		
		
		
	}
	

	
}
