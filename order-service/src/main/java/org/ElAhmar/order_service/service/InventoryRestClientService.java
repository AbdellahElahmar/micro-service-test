package org.ElAhmar.order_service.service;

import org.ElAhmar.order_service.model.Customer;
import org.ElAhmar.order_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {


    @GetMapping("/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable Long id);

    @GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> allProducts();
}
