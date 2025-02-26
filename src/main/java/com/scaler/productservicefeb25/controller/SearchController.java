package com.scaler.productservicefeb25.controller;

import com.scaler.productservicefeb25.dto.SearchRequestDto;
import com.scaler.productservicefeb25.model.Product;
import com.scaler.productservicefeb25.service.SearchService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchRequestDto searchRequestDto){
        return searchService.search(searchRequestDto.getQuery(),
                searchRequestDto.getPage(),
                searchRequestDto.getSize());
    }
}
