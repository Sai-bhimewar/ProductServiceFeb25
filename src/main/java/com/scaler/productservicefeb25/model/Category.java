package com.scaler.productservicefeb25.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    private String name;
    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    private List<Product> products;
}
