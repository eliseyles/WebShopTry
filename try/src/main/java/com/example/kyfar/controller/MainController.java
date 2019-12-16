package com.example.kyfar.controller;

import com.example.kyfar.containers.ProductRepository;
import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Product> products = productRepository.findAll();
        model.put("products", products);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            Map<String, Object> model) {
        Product product = new Product(title, user);
        productRepository.save(product);

        Iterable<Product> products = productRepository.findAll();
        model.put("products", products);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String title, Map<String, Object> model) {

        List<Product> products = productRepository.findByTitle(title);
        model.put("products", products);

        return "main";
    }

}