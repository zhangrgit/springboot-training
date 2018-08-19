package com.rz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 1工具
 *  借助以下工具可将文字或图片生成用于Banner输出的字符画
 *  http://patorjk.com/software/taag
	http://www.network-science.de/ascii/
	http://www.degraeve.com/img2txt.php
    
   2 启动顺序
        若同时存在动态和静态banner，则启动顺序,先gif动态完毕再静态文本
	
    3 作用:
         定制自己专属的启动画面，增加团队对品牌的认同感
	
 * @author 18217
 */
@SpringBootApplication
public class Application_Banner {

	public static void main(String[] args) {
		
//		SpringApplication.run(Application_Banner.class, args);
		SpringApplication  application = new SpringApplication(Application_Banner.class);
//		application.setBannerMode(Banner.Mode.OFF);//关闭banner
		application.run(args);
	}
}
