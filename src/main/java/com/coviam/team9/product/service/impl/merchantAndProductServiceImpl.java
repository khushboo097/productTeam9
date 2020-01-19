package com.coviam.team9.product.service.impl;

import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.repository.MerchantAndProductRepository;
import com.coviam.team9.product.service.MerchantAndProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class merchantAndProductServiceImpl implements MerchantAndProductService {
    @Autowired
    MerchantAndProductRepository merchantAndProductRepository;

    @Override
    public void save(MerchantAndProduct merchantAndProduct) {
        merchantAndProductRepository.save(merchantAndProduct);
    }
}
