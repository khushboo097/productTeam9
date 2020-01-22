package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DashbordUpdateDTO {
    private String merchantAndProductId;
    private int quantity;
    private double sellingPrice;
}
