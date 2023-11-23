package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojos.TextToJSON;

@Controller
public class HomeControllers1 {
	@ResponseBody
	@RequestMapping(path = "/controller1")
	public TextToJSON text() {
		return new TextToJSON("text");
	}
}