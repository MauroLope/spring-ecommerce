package com.ecommerce.springecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;
    private String name;
    private String description;
    private String image;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", price=" + price + ", quantity=" + quantity + "]";
    }


}


