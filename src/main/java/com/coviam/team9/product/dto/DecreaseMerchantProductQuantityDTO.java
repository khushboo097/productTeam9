package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecreaseMerchantProductQuantityDTO {
    //    private String _id;
    private String merchantAndProductId;
    private String merchantId;
    private int quantity;


}
