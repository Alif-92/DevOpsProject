package com.alif.dev.DevOpsProject.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	private static final Logger logger = Logger.getLogger(HelloController.class.getName());

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getIndexPage() {
		logger.info("=================GET Request for getIndexPage method=================");
		return "index";
	}
	
	@RequestMapping(value="sayHello.htm", method = RequestMethod.POST)
	public String sayHello(@RequestParam(value="name") String name, Model model) {
		logger.info("=================POST Request for sayHello method=================");
		
		model.addAttribute("name", name);
		return "home";
	}
}
