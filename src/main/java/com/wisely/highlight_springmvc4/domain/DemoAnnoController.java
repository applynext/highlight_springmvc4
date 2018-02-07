package com.wisely.highlight_springmvc4.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 1
@RequestMapping("/anno") // 2
public class DemoAnnoController {
	// 3 定制返回的response媒体类型和字符集
	@RequestMapping(produces = "text/plain; charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) { // 4
		return "url:" + request.getRequestURL() + " can access";
	}

	// 5 该注解@PathVariable表示接受路径参数
	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access,str: " + str;
	}

	@RequestMapping(value = "/requestParam", produces = "text/plain; charset=UTF-8")
	// 6 常规的request参数获取
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access,id: " + id;
	}

	// 7 演示解释参数到对象。访问路径为/anno/obj?id=1&name=xx
	@RequestMapping(value = "/obj", produces = "application/json; charset=UTF-8")
	@ResponseBody // 8 该注解也可以用在方法上
	public String passObj(DemoObj obj, HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access, obj id: " + obj.getId() + " obj name: " + obj.getName();
	}
	
	@RequestMapping(value={"/name1", "/name2"}, produces="text/plain; charset=UTF-8") // 9 映射不同的路径不相同的方法
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access";
	}
}
