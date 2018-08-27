package com.rz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rz.domain.p.User;
import com.rz.domain.s.Student;
import com.rz.repository.p.UserRepository;
import com.rz.repository.s.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Before
	public void step() {
		 userRepository.deleteAll();
		 studentRepository.deleteAll();
	}
	
	@Test
	public void test() throws Exception {

		userRepository.save(new User("张三", 10));
		userRepository.save(new User("李四", 20));
		userRepository.save(new User("王五", 30));

		Assert.assertEquals(3, userRepository.findAll().size());

		studentRepository.save(new Student("赵六", 10));
		studentRepository.save(new Student("小七", 20));
		
		Assert.assertEquals(2, studentRepository.findAll().size());

	}

	
}
