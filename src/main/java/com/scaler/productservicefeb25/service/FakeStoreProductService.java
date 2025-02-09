package com.scaler.productservicefeb25.service;

import com.scaler.productservicefeb25.dto.FakeStoreCreateProductDto;
import com.scaler.productservicefeb25.dto.FakeStoreProductDto;
import com.scaler.productservicefeb25.model.Category;
import com.scaler.productservicefeb25.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductDetails(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(Double.parseDouble(fakeStoreProductDto.getPrice()));
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product createProduct(String name, String description, String  price, String image, String category) {
        FakeStoreCreateProductDto fakeStoreCreateProductDto = new FakeStoreCreateProductDto();
        fakeStoreCreateProductDto.setTitle(name);
        fakeStoreCreateProductDto.setDescription(description);
        fakeStoreCreateProductDto.setPrice(Double.parseDouble(price));
        fakeStoreCreateProductDto.setImage(image);
        fakeStoreCreateProductDto.setCategory(category);
        FakeStoreProductDto responseDto = restTemplate.postForObject("https://fakestoreapi.com/products/", fakeStoreCreateProductDto, FakeStoreProductDto.class);
        return responseDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] responseDto=restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:responseDto){
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }
}
