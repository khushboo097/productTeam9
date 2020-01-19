package com.coviam.team9.product.service;

import com.coviam.team9.product.dto.DecreaseMerchantProductQuantity;

public interface DecreaseQuantityService {


    int changeQuantity(DecreaseMerchantProductQuantity decreaseMerchantProductQuantity);
}
