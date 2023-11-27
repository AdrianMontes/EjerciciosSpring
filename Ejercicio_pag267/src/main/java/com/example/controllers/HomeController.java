package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@ResponseBody
	@RequestMapping("{num}/factura")
	public String index(@PathVariable Integer num) {
		if (num % 2 == 0) {
			return "Es par";
		}
		return "Es impar";
	}
}
