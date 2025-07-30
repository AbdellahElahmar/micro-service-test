package org.ElAhmar.customer_service.repository;

import org.ElAhmar.customer_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;


@RepositoryRestController
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
