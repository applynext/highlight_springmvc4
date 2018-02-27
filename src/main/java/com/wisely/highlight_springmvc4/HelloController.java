package com.wisely.highlight_springmvc4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 1
public class HelloController {
	// 可以以配置类中重写addViewControllers()方法简化配置
//	@RequestMapping("/index") // 2 配置URL和方法之间的映射
//	public String hello() {
//		return "index"; // 3
//	}
}
