package com.example.controllers;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeControllers {
	@ResponseBody
	@RequestMapping(path = "/")
	public ResponseEntity<String> customStatus() {
		Random random = new Random();
		int numero = random.nextInt(2);
		if (numero == 0) {
			return new ResponseEntity<>("Respuesta: " + HttpStatus.OK, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Respuesta: " + HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}
}
