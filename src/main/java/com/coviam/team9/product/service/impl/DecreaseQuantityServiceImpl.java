package com.coviam.team9.product.service.impl;

import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.dto.DecreaseMerchantProductQuantity;
import com.coviam.team9.product.repository.DecreaseQuantityRepository;
import com.coviam.team9.product.repository.MerchantAndProductRepository;
import com.coviam.team9.product.service.DecreaseQuantityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DecreaseQuantityServiceImpl implements DecreaseQuantityService {

    @Autowired
    MerchantAndProductRepository merchantAndProductRepository;

    @Override
    public int changeQuantity(DecreaseMerchantProductQuantity decreaseMerchantProductQuantity) {

        Optional<MerchantAndProduct> merchantAndProduct = merchantAndProductRepository.findById(decreaseMerchantProductQuantity.get_id());

        int quantity;
        if (merchantAndProduct != null) {
            quantity = merchantAndProduct.get().getQuantity();
            if(quantity ==merchantAndProduct.get().getTotalSellingQuantity()){
                return -1;
            }
            if (decreaseMerchantProductQuantity.getQuantity() + merchantAndProduct.get().getTotalSellingQuantity() > quantity) {
                return (quantity - merchantAndProduct.get().getTotalSellingQuantity());
            }
        }
        merchantAndProduct.get().setTotalSellingQuantity(merchantAndProduct.get().getTotalSellingQuantity() + decreaseMerchantProductQuantity.getQuantity());
        double revenue = decreaseMerchantProductQuantity.getQuantity() * merchantAndProduct.get().getSellingPrice();
        merchantAndProduct.get().setRevenue(merchantAndProduct.get().getRevenue() + revenue);
        MerchantAndProduct merchantAndProductEditedObj = merchantAndProduct.get();
        merchantAndProductRepository.save(merchantAndProductEditedObj);
        return 0;
    }
}
