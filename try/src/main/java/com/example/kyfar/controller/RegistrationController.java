package com.example.kyfar.controller;

import com.example.kyfar.containers.UserRepository;
import com.example.kyfar.entity.Role;
import com.example.kyfar.entity.User;
import com.example.kyfar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists! Try another one");
            return "registration";
        }
        return "redirect:/login";
    }
}
