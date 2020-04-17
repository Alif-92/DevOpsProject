package com.alif.dev.DevOpsProject.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alif.dev.DevOpsProject.model.User;

@Controller
public class HelloController {
	
	private static final Logger logger = Logger.getLogger(HelloController.class.getName());

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getIndexPage() {
		logger.info("=================GET Request for getIndexPage method=================");
		return "index";
	}
	
	@RequestMapping(value="/print", method = RequestMethod.GET)
	public void printMsg() {
		logger.info("=================GET Request for printMsg method=================");
		System.out.println("Here is the print message");
	}
	
	@RequestMapping(value="sayHello.htm", method = RequestMethod.POST)
	public String sayHello(@RequestParam(value="name") String name, Model model) {
		logger.info("=================POST Request for sayHello method=================");
		
		model.addAttribute("name", name);
		return "home";
	}
	
	@RequestMapping(value="/login.htm", method = RequestMethod.GET)
	public String getLoginPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("=================GET Request for getLoginPage method=================");
		Integer sessionUserId = (Integer)request.getSession().getAttribute("sessionUserId");
		if(sessionUserId != null) {
			return response.encodeURL("redirect:/doAppLogout.htm");
		}
		model.addAttribute("userDetails", new User());
		return "login";
	}
}
