package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class discoteca {
	@ResponseBody
	@RequestMapping("/discoteca")
	public String discoteca(@RequestParam int edad) {
		if (edad < 18) {
			return "No puedes pasar tronc@!";
		} else {
			return "Puedes pasar!";
		}
	}
}
