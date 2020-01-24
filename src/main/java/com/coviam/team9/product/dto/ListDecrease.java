package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ListDecrease {
    List<DecreaseMerchantProductQuantityDTO> decreaseMerchantProductQuantityDTOS;
}
