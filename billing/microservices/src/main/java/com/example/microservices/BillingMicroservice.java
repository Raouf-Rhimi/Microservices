package com.example.microservices;


import com.example.microservices.entities.Bill;
import com.example.microservices.entities.Customer;
import com.example.microservices.entities.Product;
import com.example.microservices.entities.ProductItem;
import com.example.microservices.repositories.BillRepository;
import com.example.microservices.repositories.ProductItemRepository;
import com.example.microservices.services.CustomerService;
import com.example.microservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingMicroservice {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(BillingMicroservice.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository prdRepository,
							CustomerService customerservice,
							ProductService productService
	) {
		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Bill.class);

			Customer c1 = customerservice.findCustomerById(1L);
			System.out.println(c1.getId());
			System.out.println(c1.getName());
			System.out.println(c1.getEmail());

			Bill bill1 = billRepository.save(new Bill(null,new Date(),c1.getId(),null));

			Product p1 = productService.findProductById(1L);
			prdRepository.save(new ProductItem(null,p1.getId(),p1.getPrice(),30,bill1));
			Product p2 = productService.findProductById(2L);
			prdRepository.save(new ProductItem(null,p2.getId(),p2.getPrice(),20,bill1));

		} ;
	}
}
