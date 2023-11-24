package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojos.ToJSON;

@Controller
public class HomeControllers {
	@ResponseBody
	@GetMapping("/Ejercicio1")
	public String Ejercicio1(@RequestParam(required = false, defaultValue = "Adrian") String name, @RequestParam(required = false, defaultValue = "Montes") String surname) {
		return "Bienvenido " + name + " " + surname + "!";
	}
	
	@ResponseBody
	@GetMapping("/Ejercicio2")
	public ToJSON Ejercicio2(@RequestParam(required = false, defaultValue = "Adrian") String name, @RequestParam(required = false, defaultValue = "Montes") String surname) {
		return new ToJSON(name, surname);
	}
	
	@ResponseBody
	@GetMapping("/Ejercicio3")
	public ToJSON Ejercicio3(@RequestParam(required = false, defaultValue = "desconocido") String name, @RequestParam(required = false, defaultValue = "desconocidos") String surname) {
		return new ToJSON(name, surname);
	}
}
