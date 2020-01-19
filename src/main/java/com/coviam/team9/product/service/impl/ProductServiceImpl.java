package com.coviam.team9.product.service.impl;

import com.coviam.team9.product.document.Product;
import com.coviam.team9.product.repository.ProductRepository;
import com.coviam.team9.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product insertOrUpdate(Product product) {

        return productRepository.save(product);

    }
}
