package com.controller;

import com.config.WebSocketConfig;
import com.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-08
 * @desc:
 */
@RestController
@RequestMapping("/alarm")
public class IndexController {

	@Autowired
	private WebSocket webSocket;

	@GetMapping({"","index.html"})
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	@GetMapping("/test")
	public String test() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			Thread.sleep(1000);
			webSocket.sendMessage("hello world!");
		}
		return "success";
	}
}
