package com.example.controllers;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

@Controller
public class HomeControllers {
    private static final Logger log = (Logger) LoggerFactory.getLogger(HomeControllers.class);

	@ResponseBody
	@RequestMapping("/infinity")
	public String infinity(@RequestParam(required = false) Map<String,String> params) {
		String texto = "Parametros:";
		if (params.isEmpty()) {
			log.info("La zona de parámetro está vacía ¡No has enviado nada!");
			texto += " La zona de parámetro está vacía ¡No has enviado nada!";
		} else {
			for(Map.Entry<String, String> parametro : params.entrySet()) {
				log.info("Parámetro: " + parametro);
				texto += "\n" + parametro;
			}
		}
		return texto.toString();
	}
}
