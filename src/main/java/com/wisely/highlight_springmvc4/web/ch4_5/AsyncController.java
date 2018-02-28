package com.wisely.highlight_springmvc4.web.ch4_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.wisely.highlight_springmvc4.service.PushService;

@Controller
public class AsyncController {
	/*
	 * 异步任务是通过控制器从另外一个线程返回一个DeferredResult 
	 */
	@Autowired
	PushService pushService; // 1 定时任务，定时更新DeferredResult
	
	@RequestMapping("/defer")
	@ResponseBody
	public DeferredResult<String> deferredCall() { //2 返回给客户端DeferredResult
		return pushService.getAsyncUpdate();
	}
}
