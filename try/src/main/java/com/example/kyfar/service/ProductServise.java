package com.example.kyfar.service;

import com.example.kyfar.containers.ProductRepository;
import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.Role;
import com.example.kyfar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ProductServise {

    @Autowired
    private ProductRepository productRepository;

    public boolean deleteProduct(Product product) {
        Product productFromDb = productRepository.findById(product);

        if (productFromDb != null) {
            return false;
        }
        productRepository.delete(product);
        return true;
    }
}
