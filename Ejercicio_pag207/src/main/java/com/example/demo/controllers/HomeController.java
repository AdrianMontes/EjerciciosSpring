package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*Ejercicio 1
 * La diferencia entre @Controller y @RestController es
 * en los endpoints a los que apuntan. Con un @Controller,
 * solo apuntamos a un endpoint en específico, mientras
 * que @RestController es utilizado para que todos los
 * endpoints respondan con un JSON. Además,
 * @RestController es la suma de @Controller y
 * @ResponseBody
 */


//Ejercicio 2
@Controller
public class HomeController {
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView index = new ModelAndView();
		index.setViewName("index.html");
		return index;
	}
	@RequestMapping("/sobremi")
	public ModelAndView sobremi() {
		ModelAndView sobremi = new ModelAndView();
		sobremi.setViewName("sobremi.html");
		return sobremi;
	}
	@RequestMapping("/contacto")
	public ModelAndView contacto() {
		ModelAndView contacto = new ModelAndView();
		contacto.setViewName("contacto.html");
		return contacto;
	}
}
