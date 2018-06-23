package com.rz.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	
	@GetMapping(value="/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping(value="/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		return "Hello, "+name;
	}
}
