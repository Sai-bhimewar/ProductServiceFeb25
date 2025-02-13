package com.scaler.productservicefeb25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String price;
    private String description;
    private String image;
    private String category;

}
