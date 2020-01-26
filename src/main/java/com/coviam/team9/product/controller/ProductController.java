package com.coviam.team9.product.controller;

import com.coviam.team9.product.document.Product;
import com.coviam.team9.product.dto.AddProductDTO;
import com.coviam.team9.product.dto.ProductDTO;
import com.coviam.team9.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping(path = "/get")
    public ResponseEntity<List<Product>> getAllProducts() {
        System.out.println("=====");
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }


    @PostMapping(path = "/addProduct")
    public ResponseEntity<AddProductDTO> addProduct(@RequestBody ProductDTO productDTO) {

        System.out.println("addProduct");
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        AddProductDTO productCreated = productService.insertOrUpdate(product);

        return new ResponseEntity<AddProductDTO>(productCreated, HttpStatus.CREATED);
    }

    @GetMapping(path = "/getone/{productId}")
    public ResponseEntity<?> getOneProduct(@PathVariable(name = "productId") String productId) {
        System.out.println("getOne Called..." + productId);
        return new ResponseEntity<>(productService.getOne(productId), HttpStatus.OK);
    }


}