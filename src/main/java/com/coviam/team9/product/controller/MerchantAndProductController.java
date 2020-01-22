package com.coviam.team9.product.controller;

import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.dto.*;
import com.coviam.team9.product.repository.MerchantAndProductRepository;
import com.coviam.team9.product.service.MerchantAndProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/merchantAndProduct")
public class MerchantAndProductController {
    @Autowired
    MerchantAndProductService merchantAndProductService;

    @GetMapping(path = "/get/{categoryName}")
    public ResponseEntity<List<AllProductsByCategoryNameDTO>> getAllProductsByCategoryName(@PathVariable String categoryName) {
        return new ResponseEntity<List<AllProductsByCategoryNameDTO>>(merchantAndProductService.getProductsByCategoryNameAndMerchantRating(categoryName), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{categoryName}/{productId}/{merchantAndProductId}")
    public ResponseEntity<AllProductsByCategoryNameDTO> getProductDetails(@PathVariable String categoryName, @PathVariable String productId, @PathVariable String merchantAndProductId) {
        return new ResponseEntity<AllProductsByCategoryNameDTO>(merchantAndProductService.getOneProduct(productId, merchantAndProductId), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<MerchantAndProduct> addProductDetails(@Valid @RequestBody MerchantAndProductDTO merchantAndProductDTO) {
        MerchantAndProduct merchantAndProduct = new MerchantAndProduct();
        BeanUtils.copyProperties(merchantAndProductDTO, merchantAndProduct);
        merchantAndProductService.save(merchantAndProduct);
        return new ResponseEntity<MerchantAndProduct>(merchantAndProduct, HttpStatus.CREATED);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<MerchantAndProduct> editMerchantProductDetails(@Valid @RequestBody MerchantAndProductDTO merchantAndProductDTO) {

        MerchantAndProduct merchantAndProduct = new MerchantAndProduct();
        BeanUtils.copyProperties(merchantAndProductDTO, merchantAndProduct);
        merchantAndProductService.save(merchantAndProduct);
        return new ResponseEntity<MerchantAndProduct>(merchantAndProduct, HttpStatus.OK);
    }

    @PutMapping(path = "/decreaseQuantity")
    public ResponseEntity<Integer> decreaseMerchantProductQuantity(@Valid @RequestBody DecreaseMerchantProductQuantityDTO decreaseMerchantProductQuantityDTO) {
        return new ResponseEntity<Integer>(merchantAndProductService.changeQuantity(decreaseMerchantProductQuantityDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/dashbord/{merchantId}")
    public ResponseEntity<List<MerchantDashbordDTO>> getDashbord(@PathVariable String merchantId) {
        List<MerchantDashbordDTO> merchantDashbordDTOS = merchantAndProductService.getDashbord(merchantId);
        return new ResponseEntity<List<MerchantDashbordDTO>>(merchantDashbordDTOS, HttpStatus.OK);
    }

    @PutMapping(path = "/dashbord")
    public ResponseEntity<MessageDTO> getDashbord(@Valid @RequestBody DashbordUpdateDTO dashbordUpdateDTO) {

        return new ResponseEntity<MessageDTO>(merchantAndProductService.update(dashbordUpdateDTO), HttpStatus.OK);
    }
}
