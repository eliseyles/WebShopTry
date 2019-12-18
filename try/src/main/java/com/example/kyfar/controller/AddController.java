package com.example.kyfar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddController {
    @GetMapping("/adding")
    public String registration(){
        return "productAdd";
    }
}
