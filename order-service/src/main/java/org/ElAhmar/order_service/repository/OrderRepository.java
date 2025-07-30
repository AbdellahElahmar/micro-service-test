package org.ElAhmar.order_service.repository;


import org.ElAhmar.order_service.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@RepositoryRestController
public interface OrderRepository extends JpaRepository<Order, Long> {
}
