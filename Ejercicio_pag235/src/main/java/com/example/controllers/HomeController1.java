package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController1 {
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/apiVersion/hacercafe")
	public String index() {
		return "Hacer cafe";
	}
}
