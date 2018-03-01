package com.wisely.highlight_springmvc4.web.ch4_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisely.highlight_springmvc4.service.DemoService;

@Controller
public class MyRestController {
	@Autowired
	DemoService demoService;
	
	@RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String testRest() {
		return demoService.saySomething();
	}
}
