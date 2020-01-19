package com.coviam.team9.product.dto;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Map;

@lombok.Getter
@Setter
public class MerchantAndProductDto {
    private String _id;
    private double price;
    private String merchantId;
    private String productId;
    private int quantity;
    private String url1;
    private String url2;
    private String url3;
    private double sellingPrice;
    private int totalSellingQuantity;
    private double revenue;


}
