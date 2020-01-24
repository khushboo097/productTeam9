package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantDTO {

    private String merchantEmail;
    private String merchantPassword;
    private String merchantName;
    private String merchantImgUrl;
    private String merchantAddress;
    private String merchantLastLogin;
    private double merchantRating;

}