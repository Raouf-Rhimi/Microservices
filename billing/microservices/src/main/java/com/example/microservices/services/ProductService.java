package com.example.microservices.services;

import com.example.microservices.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="INVENTORY-SERVICE")
public interface ProductService{
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable(name="id") Long id);

}

