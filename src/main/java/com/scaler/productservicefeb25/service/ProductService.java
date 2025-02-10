package com.scaler.productservicefeb25.service;

import com.scaler.productservicefeb25.exception.ProductNotFoundException;
import com.scaler.productservicefeb25.model.Product;
import org.springframework.http.ResponseEntity;

import java.net.Proxy;
import java.util.List;


public interface ProductService {
    public Product getProductDetails(Long id) throws ProductNotFoundException;
    public Product createProduct(String name, String description,String price,String image,String category);
    public List<Product> getAllProducts();
}
