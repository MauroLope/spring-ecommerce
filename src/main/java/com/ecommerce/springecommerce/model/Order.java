package com.ecommerce.springecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;
    private String number;
    private Date dateCreation;
    private Date dateReceipt;
    private Double total;

    @Override
    public String toString() {
        return "Order [id=" + id + ", number=" + number + ", dateCreation=" + dateCreation + ", dateReceipt=" + dateReceipt + ", total=" + total + "]";
    }
}
