package org.ElAhmar.inventory_service.repository;

import org.ElAhmar.inventory_service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product, Long> {
}
