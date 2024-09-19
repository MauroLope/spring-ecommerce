package com.ecommerce.springecommerce.service;

import com.ecommerce.springecommerce.model.Product;


import java.util.List;
import java.util.Optional;

public interface IProductService {
    public Product save(Product product);
    public Optional<Product> get(Long id);
    public void update(Product product);
    public void delete(Long id);
    public List<Product> findAll();
}
