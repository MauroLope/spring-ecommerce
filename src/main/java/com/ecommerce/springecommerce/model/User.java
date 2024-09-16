package com.ecommerce.springecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String type;
    private String password;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", address=" + address + ", phone=" + phone + ", type=" + type + ", password=" + password + "]";
    }

}
