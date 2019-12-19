package com.example.kyfar.controller;

import com.example.kyfar.containers.ProductRepository;
import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.Role;
import com.example.kyfar.entity.User;
import com.example.kyfar.exceptions.NullStringDataException;
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
        Iterable<Product> products;
        if (user.isAdmin()) {
            products = productRepository.findAll();
        } else {
            products = productRepository.findByOwner(user);
        }
        model.put("products", products);
        return "productList";
    }

    @GetMapping("{product}")
    public String productEditForm(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);
        return "productEdit";
    }

    @PostMapping
    public String productSave(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String price,
            @RequestParam Map<String, Object> form,
            @RequestParam("productId") Product product) {
        Product newProduct = new Product();
        boolean flag = false;
        try {
            if (newProduct.setTitle(title) & newProduct.setDescription(description) & newProduct.setPrice(price)) {
                newProduct.setId(product.getId());
                newProduct.setOwner(product.getOwner());
                flag = true;
            }
        } catch (NullStringDataException e) {
            form.put("exception", e.getMessage());
            return "productEdit";
        }

        if (flag) {
            productRepository.save(newProduct);
            form.put("message", "New product was added.");

        } else {
            form.put("message", "Data is invalid. New product wasn't added.");

            return "productEdit";
        }

        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String productDelete(@RequestParam("productId") Product product, Model model) {
        productRepository.delete(product);
        return "redirect:/product";
    }


}
