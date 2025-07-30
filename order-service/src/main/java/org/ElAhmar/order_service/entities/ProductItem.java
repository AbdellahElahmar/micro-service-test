package org.ElAhmar.order_service.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ElAhmar.order_service.model.Product;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Product product;
    private Long productId;
    private double price;
    private int quantity;
    private double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;
}
