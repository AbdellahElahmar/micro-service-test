package org.ElAhmar.inventory_service;

import org.ElAhmar.inventory_service.entities.Product;
import org.ElAhmar.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder().name("Ordinateur").price(3000.00).quantity(20).build(),
					Product.builder().name("SmartPhone").price(1000.00).quantity(30).build(),
					Product.builder().name("Bureau").price(1200.00).quantity(10).build(),
					Product.builder().name("Machine à laver").price(2100.00).quantity(5).build()
			));
		};
	}
}
