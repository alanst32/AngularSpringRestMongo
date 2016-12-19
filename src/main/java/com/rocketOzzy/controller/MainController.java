package com.rocketOzzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	
	@RequestMapping(value="/angularMongo")
	public ModelAndView angularMongo(){
	
		return new ModelAndView("/angularMongo");
	}
	
}
