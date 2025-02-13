package com.scaler.productservicefeb25.controller;

import com.scaler.productservicefeb25.dto.CreateProductRequestDto;
import com.scaler.productservicefeb25.exception.ProductNotFoundException;
import com.scaler.productservicefeb25.model.Product;
import com.scaler.productservicefeb25.service.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto) {
        Product product= productService.createProduct(requestDto.getTitle(),requestDto.getPrice(),
                requestDto.getDescription(),
                requestDto.getImage(),
                requestDto.getCategory());
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatusCode.valueOf(202));
        return responseEntity;
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductDetails(id) ;
    }

    @GetMapping("/products")
    public List<Product> getAllProductDetails() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/limit/{id}")
    public List<Product> getProductDetailsLimit(@PathVariable("id") Long id)  {
        return productService.getLimitedProducts(id);
    }

    @GetMapping("/products/sort/{name}")
    public List<Product> getProductDetailsDesc(@PathVariable("name") String order) {
        return productService.getAllProductsOrder(order);
    }

    @GetMapping("/categories")
    public List<String> getCategoryDetails() {
        return productService.getAllCategories();
    }

    @GetMapping("/category/{name}")
    public List<Product> getProductDetailsByCategory(@PathVariable("name") String category) {
        return productService.getProductsByCategory(category);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody CreateProductRequestDto requestDto) {
        return productService.updateProductDetails(requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getPrice(),
                requestDto.getImage(),
                requestDto.getCategory(),
                id);
    }

    @DeleteMapping("products/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.deleteProductDetails(id);
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDto> NPEHandler(){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("Null pointer exeption");
//        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
//    }
//
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> ProductNotFoundHandler(){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("please try again, product not found");
//        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
//    }
}
