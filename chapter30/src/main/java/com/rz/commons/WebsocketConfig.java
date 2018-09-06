package com.rz.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 *  WebScoket配置处理器
 * @author 18217
 */
@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry arg0) {
		
		arg0.addHandler(myHandler(), "/ws").addInterceptors(new HttpSessionHandshakeInterceptor());
		arg0.addHandler(myHandler(), "/ws/sockjs").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
	}
	
	   @Bean
	    public WebsocketHandler myHandler() {
	        return new WebsocketHandler();
	    }
	

}
