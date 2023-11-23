package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController3 {
	@ResponseBody
	@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Not found")
	@RequestMapping("/apiVersion/notfound")
	public String index() {
		return "Not found";
	}
}
