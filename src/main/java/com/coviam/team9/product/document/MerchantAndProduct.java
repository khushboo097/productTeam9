package com.coviam.team9.product.document;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.ArrayList;

@Getter
@Setter
@Document
public class MerchantAndProduct {

    @Id
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
