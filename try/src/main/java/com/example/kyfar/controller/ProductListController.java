package com.example.kyfar.controller;

import com.example.kyfar.containers.ProductRepository;
import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.Role;
import com.example.kyfar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
@PreAuthorize("hasAuthority('USER')")
public class ProductListController {
    @Autowired
    private ProductRepository productRepository;

//    @GetMapping
//    public String registration(){
//        return "productList";
//    }

    @GetMapping
//    public String productList(@AuthenticationPrincipal User user, Model model) {
//        Iterable<Product> products = productRepository.findByOwner(user);
//        model.addAttribute("products", products);
//        return "productList";
//    }
    public String productList(@AuthenticationPrincipal User user, Map<String, Object> model) {
        Iterable<Product> products = productRepository.findByOwner(user);

//
        model.put("products", products);
//        model.put("filter", filter);
        return "productList";
    }
//
//    @GetMapping("{product}")
//    public String userEditForm(@PathVariable Product product, Model model) {
//        model.addAttribute("product", product);
//        return "userEdit";
//    }

//    @PostMapping
//    public String userSave(
//            @RequestParam String username,
//            @RequestParam Map<String, Object> form,
//            @RequestParam("userId") User user){
//        user.setUsername(username);
//
//        Set<String> roles = Arrays.stream(Role.values())
//                .map(Role::name)
//                .collect(Collectors.toSet());
//
//        user.getRoles().clear();
//
//        for (String key : form.keySet()) {
//            if (roles.contains(key)) {
//                user.getRoles().add(Role.valueOf(key));
//            }
//        }
//        userRepository.save(user);
//        return "redirect:/user";
//    }
}
