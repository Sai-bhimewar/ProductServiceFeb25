package com.scaler.productservicefeb25.repository;

import com.scaler.productservicefeb25.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);
    List<Product> findAll();
}
