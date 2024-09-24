package com.ecommerce.springecommerce.service;

import com.ecommerce.springecommerce.model.Product;
import com.ecommerce.springecommerce.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

   private final IProductRepository productRepository;

   @Autowired
   public ProductService(IProductRepository productRepository) {
       this.productRepository = productRepository;
   }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> get(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
