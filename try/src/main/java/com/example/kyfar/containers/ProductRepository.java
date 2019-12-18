package com.example.kyfar.containers;

import com.example.kyfar.entity.Product;
import com.example.kyfar.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByTitle(String title);

    List<Product> findByOwner(User user);

}