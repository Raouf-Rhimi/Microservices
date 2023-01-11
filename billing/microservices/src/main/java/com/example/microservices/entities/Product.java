package com.example.microservices.entities;

import lombok.Data;

@Data
public class Product{
    private Long id;
    private String name;
    private double price;
}

