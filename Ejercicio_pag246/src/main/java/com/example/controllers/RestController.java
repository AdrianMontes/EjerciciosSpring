package com.example.controllers;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojos.ToJSON;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @RequestMapping("/restcomponent")
    public ToJSON restController() {
        return new ToJSON("RestComponent", "Objeto a JSON");
    }
}
