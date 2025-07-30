package org.ElAhmar.order_service;

import org.ElAhmar.order_service.entities.Order;
import org.ElAhmar.order_service.entities.OrderStatus;
import org.ElAhmar.order_service.entities.ProductItem;
import org.ElAhmar.order_service.model.Customer;
import org.ElAhmar.order_service.model.Product;
import org.ElAhmar.order_service.repository.OrderRepository;
import org.ElAhmar.order_service.repository.ProductItemRepository;
import org.ElAhmar.order_service.service.CustomerRestClientService;
import org.ElAhmar.order_service.service.InventoryRestClientService;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}



	// Remplir la base de données avec des records
	@Bean
	CommandLineRunner commandLineRunner(OrderRepository orderRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClientService customerRestClientService,
										InventoryRestClientService inventoryRestClientService) {
		return args -> {
			List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products = inventoryRestClientService.allProducts().getContent().stream().toList();

			Random random = new Random();

			for (int i = 0; i < 20; i++) {
				Order order = Order.builder()
						.createdAt(LocalDateTime.now())
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.customer(customers.get(random.nextInt(customers.size())))
						.status(Math.random()> 0.5 ? OrderStatus.PENDING : OrderStatus.CREATED)
						.build();
				Order savedOrder = orderRepository.save(order);
				for (int j = 0; j<products.size(); j++) {
					if(Math.random() > 0.60) {
						ProductItem productItem = ProductItem.builder()
								.order(savedOrder)
								.product(products.get(j))
								.productId(products.get(j).getId())
								.quantity(random.nextInt(10) + 1)
								.price(products.get(j).getPrice())
								.discount(Math.random())
								.build();
						productItemRepository.save(productItem);
					}
				}

			}
		};
	}
}
