package com.rz.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import com.google.gson.GsonBuilder;
import com.rz.commons.WebsocketHandler;


@RestController
public class IndexController {
	
	protected static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/test")
	public String test() throws Exception {
     
		 return "test";
	}
	
	@RequestMapping("/service")
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			WebsocketHandler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson("访问service接口\\n")));
			LOG.warn("=========service1=========");
			System.out.println("================service2==============");
			out.println("=====================service3==========================");
			
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
