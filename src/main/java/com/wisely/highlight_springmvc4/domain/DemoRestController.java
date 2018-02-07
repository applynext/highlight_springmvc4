package com.wisely.highlight_springmvc4.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1 声明是控制器，并且返回数据时不需要@ResponseBody
@RequestMapping("/rest")
public class DemoRestController {
	@RequestMapping(value = "/getjson", produces = { "application/json; charset=UTF-8" }) // 2
	public DemoObj getjson(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "yy"); // 3 直接返回对象，对象会自动转换成json

	}

	@RequestMapping(value = "/getxml", produces = { "application/xml; charset=UTF-8" }) // 4
	public DemoObj getxml(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
	}
}
