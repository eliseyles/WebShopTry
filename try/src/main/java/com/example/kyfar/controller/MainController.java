package com.example.kyfar.controller;

import com.example.kyfar.containers.ProductRepository;
import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false) String filter, Map<String, Object> model) {
        Iterable<Product> products;

        if(filter != null && !filter.isEmpty()) {
             products = productRepository.findByTitle(filter);
        } else {
            products = productRepository.findAll();
        }
        model.put("products", products);
        model.put("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Product product,
            BindingResult bindingResult,
            Model model) {
        product.setOwner(user);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("product", product);
        } else {

            productRepository.save(product);
        }

        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "main";
    }



}