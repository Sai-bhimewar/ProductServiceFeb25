package com.scaler.productservicefeb25.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchRequestDto {
    private String query;
    private int page;
    private int size;
}
