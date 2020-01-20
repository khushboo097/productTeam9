package com.coviam.team9.product.service;

import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.dto.AllProductsByCategoryNameDTO;
import com.coviam.team9.product.dto.DecreaseMerchantProductQuantityDTO;
import com.coviam.team9.product.dto.ProductGetDTO;

import java.util.List;

public interface MerchantAndProductService {

    void save(MerchantAndProduct merchantAndProduct);

    int changeQuantity(DecreaseMerchantProductQuantityDTO decreaseMerchantProductQuantityDTO);

    List<AllProductsByCategoryNameDTO> getProductsByCategoryNameAndMerchantRating(String categoryName);

    AllProductsByCategoryNameDTO getOneProduct(String productIds, String merchantAndProductId);
}
