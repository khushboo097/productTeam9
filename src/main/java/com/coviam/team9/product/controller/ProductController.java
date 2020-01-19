package com.coviam.team9.product.controller;

import com.coviam.team9.product.document.Product;
import com.coviam.team9.product.dto.ProductDTO;
import com.coviam.team9.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {

        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        Product productCreated = productService.insertOrUpdate(product);

        return new ResponseEntity<Product>(productCreated, HttpStatus.CREATED);


    }


}
