package com.example.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojos.ToJSON;

@Component
@Controller
public class ComponentController {
	@ResponseBody
	@RequestMapping("/component")
	public ToJSON component() {
		return new ToJSON("Component", "Objeto a JSON");
	}
}
