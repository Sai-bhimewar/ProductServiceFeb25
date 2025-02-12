package com.scaler.productservicefeb25.service;

import com.scaler.productservicefeb25.dto.FakeStoreCreateProductDto;
import com.scaler.productservicefeb25.dto.FakeStoreProductDto;
import com.scaler.productservicefeb25.exception.ProductNotFoundException;
import com.scaler.productservicefeb25.model.Category;
import com.scaler.productservicefeb25.model.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreAPI")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductDetails(Long id) throws ProductNotFoundException{
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        Product product = new Product();
//        product.setId(fakeStoreProductDto.getId());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setPrice(Double.parseDouble(fakeStoreProductDto.getPrice()));
//        product.setImage(fakeStoreProductDto.getImage());
//        Category category = new Category();
//        category.setName(fakeStoreProductDto.getCategory());
//        product.setCategory(category);

//        if(fakeStoreProductDto.getBody()==null) {
//            ErrorDto errorDto = new ErrorDto();
//            errorDto.setMessage("Product not found");
//            return new ResponseEntity<>(errorDto,HttpStatusCode.valueOf(404));
//        }
        FakeStoreProductDto responseBody = fakeStoreProductDto.getBody();
        if(responseBody == null) {
            throw new ProductNotFoundException();
        }
        return responseBody.toProduct();
    }

    @Override
    public Product createProduct(String name, String  price,String description,  String image, String category) {
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

    @Override
    public List<Product> getLimitedProducts(Long id) {
        FakeStoreProductDto[] responseArray=restTemplate.getForObject("https://fakestoreapi.com/products?limit="+id, FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:responseArray){
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public List<Product> getAllProductsOrder(String order) {
        FakeStoreProductDto[] responseArray=restTemplate.getForObject("https://fakestoreapi.com/products?sort="+order, FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:responseArray){
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public List<String> getAllCategories() {
        String[] responseArray=restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);
        List<String> categories = new ArrayList<>();
        for(String category:responseArray){
            categories.add(category);
        }
        return categories;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        FakeStoreProductDto[] responseArray=restTemplate.getForObject("https://fakestoreapi.com/products/category/"+category, FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:responseArray){
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public Product updateProductDetails(String name, String description, String  price, String image, String category,Long id) {
        FakeStoreCreateProductDto fakeStoreCreateProductDto =new FakeStoreCreateProductDto();
        fakeStoreCreateProductDto.setTitle(name);
        fakeStoreCreateProductDto.setDescription(description);
        fakeStoreCreateProductDto.setPrice(Double.parseDouble(price));
        fakeStoreCreateProductDto.setImage(image);
        fakeStoreCreateProductDto.setCategory(category);
        ResponseEntity<FakeStoreCreateProductDto> responseEntity=new ResponseEntity<>(fakeStoreCreateProductDto, HttpStatus.OK);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto=restTemplate.exchange("https://fakestoreapi.com/products/"+id, HttpMethod.PUT,responseEntity, FakeStoreProductDto.class);
        return fakeStoreProductDto.getBody().toProduct();
    }

    @Override
    public Product deleteProductDetails(Long id) throws ProductNotFoundException{
        ResponseEntity<FakeStoreProductDto> response=restTemplate.exchange("https://fakestoreapi.com/products/"+id, HttpMethod.DELETE, null, FakeStoreProductDto.class);
        if(response.getBody()==null){
            throw new ProductNotFoundException();
        }
        return response.getBody().toProduct();
    }
}
