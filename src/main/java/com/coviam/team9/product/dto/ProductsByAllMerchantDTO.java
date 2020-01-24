package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class ProductsByAllMerchantDTO {
    private String merchantAndProductId;
    private String merchantId;
    private String productId;
    private int quantity;
    private double sellingPrice;
    private double merchantRating;
    private String merchantName;
}
