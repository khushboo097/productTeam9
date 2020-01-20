package com.coviam.team9.product.service;


import com.coviam.team9.product.document.Product;

import java.util.List;


public interface ProductService {
    public String insertOrUpdate(Product product);

    List<Product> getAllProducts();
}
