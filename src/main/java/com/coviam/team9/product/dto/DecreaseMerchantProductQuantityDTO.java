package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DecreaseMerchantProductQuantityDTO {
    private String merchantAndProductId;
//    private String merchantId;
    private int quantity;
}
