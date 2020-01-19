package com.coviam.team9.product.dto;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@lombok.Getter
@Setter
public class MerchantAndProductDto {
    private ObjectId _id;
    private double price;
    private String merchantId;
    private String productId;
    private int quantity;
    private int sellingPrice;
    private String url1;
    private String url2;
    private String url3;

}
