package com.example.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojos.Persona;

import ch.qos.logback.classic.Logger;

@Controller
public class HomeController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(HomeController.class);
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public Persona GetPersona(@RequestParam(required = false, defaultValue = "Adrian") String nombre, @RequestParam(required = false, defaultValue = "Montes Muñoz") String apellidos, @RequestParam(required = false, defaultValue = "23") Integer edad) {
		log.info("Recibiendo persona: Nombre: " + nombre + "; Apellidos: " + apellidos + "; Edad: " + edad);
		return new Persona(nombre, apellidos, edad);
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Persona CreatePersona(@RequestParam(required = false) String nombre, @RequestParam(required = false) String apellidos, @RequestParam(required = false) Integer edad) {
		log.info("Persona creada: Nombre: " + nombre + "; Apellidos: " + apellidos + "; Edad: " + edad);
		return new Persona(nombre, apellidos, edad);
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.DELETE)
	public String DeletePersona(@RequestParam(defaultValue = " ") String nombre) {
		if (nombre.isEmpty()) {
			log.info("Persona eliminada: " + nombre);
			return "Persona eliminada: " + nombre;
		}
		return "No has seleccionado ninguna persona";
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.PUT)
	public String PutPersona(@RequestParam String nombre, @RequestParam String apellidos, @RequestParam Integer edad) {
		log.info("Persona recibida: Nombre: " + nombre + "; Apellidos: " + apellidos + "; Edad: " + edad);
		return "Persona recibida: Nombre: " + nombre + "; Apellidos: " + apellidos + "; Edad: " + edad;
	}
}
