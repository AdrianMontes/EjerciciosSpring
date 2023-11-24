package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@ResponseBody
	@RequestMapping("/hola")
	public ModelAndView index() {
		ModelAndView index = new ModelAndView();
		index.setViewName("index.html");
		return index;
	}
}
