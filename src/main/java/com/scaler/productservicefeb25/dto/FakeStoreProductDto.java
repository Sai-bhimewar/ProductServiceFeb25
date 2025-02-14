package com.scaler.productservicefeb25.dto;

import com.scaler.productservicefeb25.model.Category;
import com.scaler.productservicefeb25.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;


    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(Double.parseDouble(getPrice()));
        product.setImage(getImage());
        Category category = new Category();
        category.setName(getCategory());
        product.setCategory(category);
        return product;
    }
}
