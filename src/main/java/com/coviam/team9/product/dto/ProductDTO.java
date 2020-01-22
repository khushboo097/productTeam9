package com.coviam.team9.product.dto;

import com.coviam.team9.product.document.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class ProductDTO {

    private String productId;
    private String productName;
    private Map<String, String> attributes;
    private String categoryName;
    private double productRating;
    private double price;
    private String description;
    private String url1;
    private String url2;
    private String url3;
}