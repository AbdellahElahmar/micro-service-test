package org.ElAhmar.order_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ElAhmar.order_service.model.Customer;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private Long customerId;

    @Transient
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<ProductItem>  productItems;
}
