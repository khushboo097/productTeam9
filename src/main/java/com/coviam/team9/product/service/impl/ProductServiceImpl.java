package com.coviam.team9.product.service.impl;

import com.coviam.team9.product.document.Product;
import com.coviam.team9.product.repository.ProductRepository;
import com.coviam.team9.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public String insertOrUpdate(Product product) {
        List<Product> productList = productRepository.findByProductNameAndDescriptionAndCategoryName(product.getProductName(), product.getDescription(), product.getCategoryName());
        if (productList.size() > 0) {
            System.out.println("product is already registered.... ");
            return productList.get(0).getProductId();
        }
        return productRepository.save(product).getProductId();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
