package com.scaler.productservicefeb25.service;

import com.scaler.productservicefeb25.model.Product;

public interface ProductService {
    public Product getProductDetails(Long id);
    public Product createProduct(String name, String description,String price,String image,String category);
}
