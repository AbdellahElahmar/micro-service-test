package org.ElAhmar.order_service.repository;

import org.ElAhmar.order_service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
