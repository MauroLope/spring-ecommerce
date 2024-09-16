package com.ecommerce.springecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "orders_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String name;
    private Double price;
    private int quantity;
    private String total;

    @OneToOne
    private Order order;

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "OrderDetail [orderId=" + orderId + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", total=" + total + "]";
    }

}
