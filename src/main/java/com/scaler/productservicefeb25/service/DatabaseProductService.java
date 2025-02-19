package com.scaler.productservicefeb25.service;

import com.scaler.productservicefeb25.exception.ProductNotFoundException;
import com.scaler.productservicefeb25.model.Category;
import com.scaler.productservicefeb25.model.Product;
import com.scaler.productservicefeb25.repository.CategoryRepository;
import com.scaler.productservicefeb25.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("Database")
public class DatabaseProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public DatabaseProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductDetails(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public Product createProduct(String name, String price, String description, String image, String category) {
        Product product = new Product();
        product.setTitle(name);
        product.setPrice(Double.parseDouble(price));
        product.setDescription(description);
        product.setImage(image);
        Category categoryFromDB=categoryRepository.findByName(category);
        if(categoryFromDB==null){
            categoryFromDB=new Category();
            categoryFromDB.setName(category);
            categoryFromDB=categoryRepository.save(categoryFromDB);
        }
        product.setCategory(categoryFromDB);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getLimitedProducts(Long id) {
        return List.of();
    }

    @Override
    public List<Product> getAllProductsOrder(String order) {
        return List.of();
    }

    @Override
    public List<String> getAllCategories() {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public Product updateProductDetails(String name, String description, String price, String image, String category, Long id) {
        Product product=productRepository.findById(id).get();
        product.setTitle(name);
        product.setDescription(description);
        product.setPrice(Double.parseDouble(price));
        product.setImage(image);
        Category categoryFromDB=categoryRepository.findByName(category);
        if(categoryFromDB==null){
            Category category1=new Category();
            category1.setName(category);
            categoryFromDB=categoryRepository.save(category1);
        }
        product.setCategory(categoryFromDB);
        return productRepository.save(product);
    }

    @Override
    public Product deleteProductDetails(Long id) throws ProductNotFoundException {
        return null;
    }
}
