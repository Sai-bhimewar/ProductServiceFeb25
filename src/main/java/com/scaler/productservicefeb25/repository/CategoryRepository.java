package com.scaler.productservicefeb25.repository;

import com.scaler.productservicefeb25.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
