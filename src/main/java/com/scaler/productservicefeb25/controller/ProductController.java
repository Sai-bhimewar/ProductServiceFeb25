package com.scaler.productservicefeb25.controller;

import com.scaler.productservicefeb25.dto.CreateProductRequestDto;
import com.scaler.productservicefeb25.model.Product;
import com.scaler.productservicefeb25.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto) {
        return productService.createProduct(requestDto.getName(),
                requestDto.getDescription(),
                requestDto.getPrice(),
                requestDto.getImage(),
                requestDto.getCategory());
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) {
        return productService.getProductDetails(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProductDetails() {
        return productService.getAllProducts();
    }
}
