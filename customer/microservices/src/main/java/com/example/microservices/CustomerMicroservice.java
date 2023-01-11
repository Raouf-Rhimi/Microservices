package com.example.microservices;


import com.example.microservices.entities.Customer;
import com.example.microservices.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerMicroservice {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroservice.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Customer.class);

			customerRepository.save(new Customer(null,"ISET","Iset@rnu.tn"));
			customerRepository.save(new Customer(null,"ISG","Isg@rnu.tn"));
			customerRepository.save(new Customer(null,"ENSI","Ensi@rnu.tn"));

			customerRepository.findAll().forEach(System.out::println);
		};
	}
}

