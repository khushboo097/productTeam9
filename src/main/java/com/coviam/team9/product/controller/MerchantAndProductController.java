package com.coviam.team9.product.controller;

import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.dto.MerchantAndProductDto;
import com.coviam.team9.product.repository.MerchantAndProductRepository;
import com.coviam.team9.product.service.MerchantAndProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/merchantAndProduct")
public class MerchantAndProductController {
    @Autowired
    MerchantAndProductService merchantAndProductService;

    @Autowired
    MerchantAndProductRepository merchantAndProductRepository;

    @GetMapping(path = "/get")
    public ResponseEntity<List<MerchantAndProduct>> getAll() {
        return new ResponseEntity<List<MerchantAndProduct>>(merchantAndProductRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<MerchantAndProduct> createPet(@Valid @RequestBody MerchantAndProductDto merchantAndProductDto) {
        MerchantAndProduct merchantAndProduct = new MerchantAndProduct();
        BeanUtils.copyProperties(merchantAndProductDto, merchantAndProduct);
        merchantAndProductService.save(merchantAndProduct);
        return new ResponseEntity<MerchantAndProduct>(merchantAndProduct, HttpStatus.CREATED);
    }
}
