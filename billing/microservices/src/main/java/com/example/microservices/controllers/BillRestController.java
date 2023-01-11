package com.example.microservices.controllers;

import com.example.microservices.entities.Bill;
import com.example.microservices.repositories.BillRepository;
import com.example.microservices.repositories.ProductItemRepository;
import com.example.microservices.services.CustomerService;
import com.example.microservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController{
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductItemRepository prodcutItemRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @GetMapping(path="/dataBill/{id}")
    public Bill getBill(@PathVariable(name="id") Long id) {
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerID()));

        bill.getProductItems().forEach(pi->{
            pi.setProduct(productService.findProductById(pi.getProductID()));
        });

        return bill;
    }
}
