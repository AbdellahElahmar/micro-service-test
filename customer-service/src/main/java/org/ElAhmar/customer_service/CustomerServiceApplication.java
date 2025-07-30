package org.ElAhmar.customer_service;

import org.ElAhmar.customer_service.entities.Customer;
import org.ElAhmar.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(
					Customer.builder()
							.name("Abdellah")
							.email("abdellah@gmail.com")
							.build()
			);
			customerRepository.save(
					Customer.builder()
							.name("Hassan")
							.email("hassan@gmail.com")
							.build()
			);
			customerRepository.save(
					Customer.builder()
							.name("Youssef")
							.email("youssef@gmail.com")
							.build()
			);
		};
	}

}
