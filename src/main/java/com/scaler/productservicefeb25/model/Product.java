package com.scaler.productservicefeb25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private Double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
    private Integer quantity;
}
