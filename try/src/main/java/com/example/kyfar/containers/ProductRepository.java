package com.example.kyfar.containers;

import com.example.kyfar.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByTitle(String title);

}