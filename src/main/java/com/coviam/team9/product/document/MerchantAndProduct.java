package com.coviam.team9.product.document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
@ToString
@Document
public class MerchantAndProduct {

    @Id
    private String _id;
    private double price;
    private String merchantId;
    private String productId;
    private int quantity;
    private double sellingPrice;
    private String url1;
    private String url2;
    private String url3;
    private int totalSellingQuantity;
    private double revenue;

}
