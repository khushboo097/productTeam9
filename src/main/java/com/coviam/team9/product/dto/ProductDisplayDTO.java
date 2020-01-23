package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
@Setter
@ToString
public class ProductDisplayDTO {
    private String categoryName;
    private String productId;
    private String merchantAndProductId;
}
