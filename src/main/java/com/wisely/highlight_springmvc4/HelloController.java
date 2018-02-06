package com.wisely.highlight_springmvc4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 1
public class HelloController {
	@RequestMapping("/index") // 2 配置URL和方法之间的映射
	public String hello() {
		return "index"; // 3
	}
}
