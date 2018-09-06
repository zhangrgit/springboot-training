package com.rz.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@RequestMapping("/realtimeLog")
	public String home() throws Exception {
	    return "test";
	}
}
