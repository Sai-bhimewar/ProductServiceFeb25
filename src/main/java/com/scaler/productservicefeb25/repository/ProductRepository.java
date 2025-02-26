package com.scaler.productservicefeb25.repository;

import com.scaler.productservicefeb25.model.Product;
import com.scaler.productservicefeb25.repository.projection.ProductTitleAndDescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Optional<Product> findByTitleAndCategory_Name(String title, String category);

    @Query(value = "select p from Product p where p.category.name=:name")
    Product getProductDetails(@Param("name") String name);

    @Query(value = "select * from product where title=:name",nativeQuery = true)
    Product getProductDetaisl2(@Param("name") String name);

    @Query(value = "select title,description from product where id=:id",nativeQuery = true)
    ProductTitleAndDescription getProductDetails3(@Param("id") Long id);

    Page<Product> findByTitleContaining(String query, Pageable pageable);
}
