package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AllCartDetailsDTO {

    private double sellingPrice;

    private String productId;
    private String productName;
    private String description;
    private double productRating;
    private String categoryName;
    private String url1;
    private double price;
    private String merchantName;

}
