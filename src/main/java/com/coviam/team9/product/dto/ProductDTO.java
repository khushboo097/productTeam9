package com.coviam.team9.product.dto;

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


}
