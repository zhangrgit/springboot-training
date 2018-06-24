package com.rz.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rz.exception.MyException;

/**
 * controller 增强器
 * @author 18217
 * 在spring 3.2中，新增了@ControllerAdvice 注解，可以用于定义@ExceptionHandler、@InitBinder、@ModelAttribute，并应用到所有@RequestMapping中。参考：http://docs.spring.io/spring-framework/docs/5.0.0.M1/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html
 * 全局异常处理类
 * 启动应用后，被 @ExceptionHandler、@InitBinder、@ModelAttribute 注解的方法，都会作用在 被 @RequestMapping 注解的方法上。
 */
@ControllerAdvice
public class MyControllerAdvice {
	
	/**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
	@InitBinder
	public void initBinder(WebDataBinder binder) {}
	
	 /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
	@ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "rz");
    }
	
	 /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public Map<String,Object> errorHandler(Exception ex) {
		
		Map<String,Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
		
	}
	
//	 /**
//     * 拦截捕捉自定义异常 MyException.class
//     * @param ex
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(value = MyException.class)
//    public Map<String,Object> myErrorHandler(MyException ex) {
//    	Map<String,Object> map = new HashMap<>();
//        map.put("code", ex.getCode());
//        map.put("msg", ex.getMsg());
//        return map;
//    }
	
	
	@ExceptionHandler(value = MyException.class)
	public ModelAndView myErrorHandler(MyException ex) {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    modelAndView.addObject("code", ex.getCode());
	    modelAndView.addObject("msg", ex.getMsg());
	    return modelAndView;
	}
	
	
}
