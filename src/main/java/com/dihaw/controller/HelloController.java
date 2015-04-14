package com.dihaw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static int counter = 0;
	private static String INDEX_VIEW = "view/hello";
	private static String ABOUT_VIEW = "view/about";
	private static String MESSAGE = "message";
	private static String COUNTER = "counter";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Model model) {
 
		model.addAttribute(MESSAGE, "Welcome");
		model.addAttribute(COUNTER, ++counter);
		
		logger.debug("welcome counter : {}", counter);
 
		return INDEX_VIEW;
 
	}
 
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, Model model) {
 
		model.addAttribute(MESSAGE, "Welcome " + name);
		model.addAttribute(COUNTER, ++counter);
		
		logger.debug("welcomeName counter : {}", counter);
		
		return INDEX_VIEW;
 
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String showAboutView() {
 
		return ABOUT_VIEW;
	}

}
