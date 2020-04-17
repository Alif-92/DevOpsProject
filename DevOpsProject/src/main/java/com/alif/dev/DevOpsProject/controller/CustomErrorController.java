package com.alif.dev.DevOpsProject.controller;

import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController{
	
	private static final Logger logger = Logger.getLogger(CustomErrorController.class.getName());
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		logger.info("=================Request for handleError method=================");
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	;model.addAttribute("customErrorMsg", "Your request page is not found, Please contact support!");
	            //return "error-404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	model.addAttribute("customErrorMsg", "Server is busy at the moment, Please try later!");
	            //return "error-500";
	        }else {
	        	model.addAttribute("customErrorMsg", "Something went wrong, Please try again later!");
	        }
	    }
	    return "error";
	}
 
    @Override
    public String getErrorPath() {
        return "/error";
    }

}
