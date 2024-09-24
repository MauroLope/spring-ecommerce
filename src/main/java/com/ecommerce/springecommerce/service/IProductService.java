package com.ecommerce.springecommerce.service;

import com.ecommerce.springecommerce.model.Product;


import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product save(Product product);
    Optional<Product> get(Long id);
    void update(Product product);
    void delete(Long id);
    List<Product> findAll();
}
