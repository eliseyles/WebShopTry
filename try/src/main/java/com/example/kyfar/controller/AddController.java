package com.example.kyfar.controller;

import com.example.kyfar.containers.ProductRepository;
import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.User;
import com.example.kyfar.exceptions.NullStringDataException;
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
            @RequestParam String description,
            @RequestParam String price,
            Model model) {
        Product product = new Product();
        boolean flag = false;
        try {
            if (product.setTitle(title) & product.setDescription(description) & product.setPrice(price)) {
                product.setOwner(user);
                flag = true;
            }
        } catch (NullStringDataException e) {
            model.addAttribute("exception", e.getMessage());
            return "productAdd";
        }

        if (flag) {
            productRepository.save(product);
            model.addAttribute("message", "New product was added.");

        } else {
            model.addAttribute("message", "Data is invalid. New product wasn't added.");
            product = null;
            return "productAdd";
        }

        model.addAttribute("products", productRepository.findAll());

        return "redirect:/main";
    }
}
