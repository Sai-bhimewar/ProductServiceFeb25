package com.scaler.productservicefeb25.controller;

import com.scaler.productservicefeb25.dto.CreateProductRequestDto;
import com.scaler.productservicefeb25.dto.ErrorDto;
import com.scaler.productservicefeb25.exception.ProductNotFoundException;
import com.scaler.productservicefeb25.model.Product;
import com.scaler.productservicefeb25.service.ProductService;
import org.springframework.http.HttpStatus;
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
        Product product= productService.createProduct(requestDto.getName(),
                requestDto.getDescription(),
                requestDto.getPrice(),
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
