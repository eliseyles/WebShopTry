package com.example.kyfar.controller;

import com.example.kyfar.containers.ProductRepository;
import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class AddController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/adding")
    public String registration(){
        return "productAdd";
    }

    @PostMapping("/adding")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            Model model) {
        Product product = new Product(title, user);
        productRepository.save(product);

        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "redirect:/main";
    }
}
