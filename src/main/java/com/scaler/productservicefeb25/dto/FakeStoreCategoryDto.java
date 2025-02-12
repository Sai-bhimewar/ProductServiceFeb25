package com.scaler.productservicefeb25.dto;

import com.scaler.productservicefeb25.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCategoryDto {
    private String categoryName;

    public Category toCategory() {
        Category category = new Category();
        category.setName(getCategoryName());
        return category;
    }
}
