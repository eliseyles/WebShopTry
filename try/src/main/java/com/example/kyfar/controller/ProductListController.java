package com.example.kyfar.controller;

import com.example.kyfar.containers.ProductRepository;
import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.Role;
import com.example.kyfar.entity.User;
import com.example.kyfar.service.ProductServise;
import com.example.kyfar.service.UserService;
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
    @Autowired
    private ProductServise productServise;


    @GetMapping
    public String productList(@AuthenticationPrincipal User user, Map<String, Object> model) {
        Iterable<Product> products = productRepository.findByOwner(user);
        model.put("products", products);
        return "productList";
    }

    @GetMapping("{product}")
    public String productEditForm(@PathVariable Product product, Model model) {

//        if(deleteFilter != null && !deleteFilter.isEmpty()) {
//            productRepository.delete(product);
////            return "redirect:/product";
//        }

        model.addAttribute("product", product);
        return "productEdit";
    }

    @PostMapping
    public String productSave(
            @RequestParam String title,
            @RequestParam Map<String, Object> form,
            @RequestParam("productId") Product product){

        product.setTitle(title);
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String productDelete(@RequestParam("productId") Product product, Model model){
        productRepository.delete(product);
        return "redirect:/product";
    }


}
