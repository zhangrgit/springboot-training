package com.rz.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 通过控制台的输出我们发现，添加 @Order 注解的实现类最先执行，并且 @Order()里面的值越小启动越早。
        在实践中，使用 ApplicationRunner也可以达到相同的目的，两着差别不大。
 * @author 18217
 */
@Component
@Order(1)
public class OrderRunner1 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		 System.out.println("The OrderRunner1 start to initialize ...");
		 
	}

}
