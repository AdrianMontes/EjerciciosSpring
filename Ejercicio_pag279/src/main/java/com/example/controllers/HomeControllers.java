package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeControllers {
	@ResponseBody
	@RequestMapping(path = "/request", method = RequestMethod.GET)
	public String request() {
		return "RequestMapping";
	}
	
	@ResponseBody
	@GetMapping(path = "/get")
	public String get() {
		return "GetMapping";
	}
}
