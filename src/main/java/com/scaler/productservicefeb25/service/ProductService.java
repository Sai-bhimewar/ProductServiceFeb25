package com.scaler.productservicefeb25.service;

import com.scaler.productservicefeb25.exception.ProductNotFoundException;
import com.scaler.productservicefeb25.model.Product;

import java.util.List;


public interface ProductService {
    public Product getProductDetails(Long id) throws ProductNotFoundException;
    public Product createProduct(String name, String price,String description,String image,String category);
    public List<Product> getAllProducts();
    public List<Product> getLimitedProducts(Long id);
    public List<Product> getAllProductsOrder(String order);
    public List<String> getAllCategories();
    public List<Product> getProductsByCategory(String category);
    public Product updateProductDetails(String name, String description, String  price, String image, String category,Long id);
    public Product deleteProductDetails(Long id) throws ProductNotFoundException;
}
