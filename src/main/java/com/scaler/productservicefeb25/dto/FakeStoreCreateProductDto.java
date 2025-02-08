package com.scaler.productservicefeb25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductDto {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
