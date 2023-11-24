package com.example.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class caraOCruz {
	@ResponseBody
	@RequestMapping("/caracruz")
	public String caraOCruz(@RequestParam String tirada) {
		Random random = new Random();
		int hasGanado = random.nextInt(2);
		if ("cara".equalsIgnoreCase(tirada.toLowerCase())) {
			if (hasGanado == 0) {
				return "Has elegido cara<br>Has ganado";
			} else {
				return "Has elegido cara<br>Has perdido";
			}
		} else if ("cruz".equalsIgnoreCase(tirada.toLowerCase())) {
			if (hasGanado == 0) {
				return "Has elegido cruz<br>Has ganado";
			} else {
				return "Has elegido cruz<br>Has perdido";
			}
		} else {
			return "No has elegido una tirada correcta";
		}
	}
}
