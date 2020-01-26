package com.coviam.team9.product.service;


import com.coviam.team9.product.document.Product;
import com.coviam.team9.product.dto.AddProductDTO;

import java.util.List;


public interface ProductService {
    public AddProductDTO insertOrUpdate(Product product);

    List<Product> getAllProducts();

    Product getOne(String productId);
}
