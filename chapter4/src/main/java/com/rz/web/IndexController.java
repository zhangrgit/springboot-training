package com.rz.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rz.exception.MyException;

@Controller
public class IndexController {
	
	@RequestMapping("/home")
	public String home() throws Exception {
//	        throw new Exception("rz 错误");
	    throw new MyException("101", "rz 错误");

	}

	
	@RequestMapping("/home2")
	@ResponseBody
	public void home(ModelMap modelMap) {
	    System.out.println(modelMap.get("author"));
	}

	//author或者通过@ModelAttribute获取

	@RequestMapping("/home3")
	@ResponseBody
	public void home(@ModelAttribute("author") String author) {
	    System.out.println(author);
	}
}
