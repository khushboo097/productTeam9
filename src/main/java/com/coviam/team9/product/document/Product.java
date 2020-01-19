package com.coviam.team9.product.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;


@Getter
@Setter
@Document(collection = Product.COLLECTION_NAME)
public class Product {

    public static final String COLLECTION_NAME = "product";

    @Id
    private String productId;
    private String productName;
    private Map<String, String> attributes;
    private String categoryName;
    private double productRating;

}
