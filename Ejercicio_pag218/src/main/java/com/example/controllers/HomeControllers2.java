package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeControllers2 {
	@ResponseBody
	@RequestMapping(path = "/controller2", produces="application/json")
	public String string() {
		return "{\"tipo\": \"string\"}";
	}
}
