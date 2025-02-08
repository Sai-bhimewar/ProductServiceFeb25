package com.scaler.productservicefeb25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String name;
    private String description;
    private String price;
    private String category;
    private String image;
}
