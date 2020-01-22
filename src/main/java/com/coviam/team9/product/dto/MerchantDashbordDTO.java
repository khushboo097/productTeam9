package com.coviam.team9.product.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class MerchantDashbordDTO {


    private String merchantId;

    private int totalSellingQuantity;
    private double revenue;
    private String productId;
    private String productName;
    private String description;
    private double productRating;
    private String categoryName;
    private double price;
    private String merchantAndProductId;
    private int quantity;
    private double sellingPrice;
    private String url1;
    private String url2;
    private String url3;
    Map<String, String> attributes;
}
