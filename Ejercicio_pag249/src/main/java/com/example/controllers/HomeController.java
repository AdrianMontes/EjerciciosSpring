package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@ResponseBody
	@RequestMapping(path = {"/hola", "/hello", "/salut"})
	public String mensaje() {
		return "Hello, hola, salut";
	}
}
