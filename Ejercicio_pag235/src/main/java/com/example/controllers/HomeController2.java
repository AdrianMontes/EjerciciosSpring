package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController2 {
	@ResponseBody
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@RequestMapping("/apiVersion/hacerte")
	public String index() {
		return "Soy una tetera!";
	}
}
