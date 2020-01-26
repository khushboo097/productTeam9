package com.coviam.team9.product.document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;



@Getter
@Setter
@ToString
@Document(collection = Product.COLLECTION_NAME)
public class Product {
    public static final String COLLECTION_NAME = "product";
    @Id
    private String productId;
    private Map<String, String> attributes;
    private String productName;
    private String description;
    private double price;
    private String categoryName;
    private double productRating;
    private String url1;
    private String url2;
    private String url3;
}
