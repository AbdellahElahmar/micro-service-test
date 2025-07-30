package org.ElAhmar.order_service.web;

import lombok.AllArgsConstructor;
import org.ElAhmar.order_service.entities.Order;
import org.ElAhmar.order_service.model.Customer;
import org.ElAhmar.order_service.model.Product;
import org.ElAhmar.order_service.repository.OrderRepository;
import org.ElAhmar.order_service.service.CustomerRestClientService;
import org.ElAhmar.order_service.service.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {

    private final OrderRepository orderRepository;
    private final CustomerRestClientService customerRestClientService;
    private final InventoryRestClientService inventoryRestClientService;


    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(p -> {
            Product product = inventoryRestClientService.productById(p.getProductId());
            p.setProduct(product);
        });
        return order;
    }
}
