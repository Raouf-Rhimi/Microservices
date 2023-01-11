package com.example.microservices;

import com.example.microservices.entities.Product;
import com.example.microservices.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProductMicroservice {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroservice.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository prdRepository) {
		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Product.class);

			prdRepository.save(new Product(null,"Ordinateur",1500));
			prdRepository.save(new Product(null,"Imprimante",250));
			prdRepository.findAll().forEach(System.out::println);
		};
	}
}

