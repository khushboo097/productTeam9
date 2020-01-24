package com.coviam.team9.product.service;

import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.dto.*;

import java.util.List;

public interface MerchantAndProductService {

    void save(MerchantAndProduct merchantAndProduct);

    void changeQuantity(DecreaseMerchantProductQuantityDTO decreaseMerchantProductQuantityDTO);

    List<AllProductsByCategoryNameDTO> getProductsByCategoryNameAndMerchantRating(String categoryName);

    AllProductsByCategoryNameDTO getOneProduct(String productIds, String merchantAndProductId);

    List<MerchantDashbordDTO> getDashbord(String merchantId);

    MessageDTO update(DashbordUpdateDTO dashbordUpdateDTO);

    AllCartDetailsDTO getCartDetailsByMerchantAndProductId(String merchantAndProductId);

    List<ProductsByAllMerchantDTO> getAllMerchantByProductId(String productId);

    MerchantAndProduct getMerchant(String merchantAndProductId);
}
