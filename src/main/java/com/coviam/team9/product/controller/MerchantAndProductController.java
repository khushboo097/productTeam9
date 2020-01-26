package com.coviam.team9.product.controller;

import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.dto.*;
import com.coviam.team9.product.repository.MerchantAndProductRepository;
import com.coviam.team9.product.service.MerchantAndProductService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/merchantAndProduct")
public class MerchantAndProductController {
    @Autowired
    MerchantAndProductService merchantAndProductService;

    @GetMapping(path = "/get/{categoryName}")
    public ResponseEntity<?> getAllProductsByCategoryName(@RequestHeader Map<String, String> headerss, @PathVariable String categoryName) {


        System.out.println("==>" + categoryName);
        headerss.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<List<AllProductsByCategoryNameDTO>>(merchantAndProductService.getProductsByCategoryNameAndMerchantRating(categoryName), HttpStatus.OK);
    }

    @GetMapping(path = "/getDetails/{merchantAndProductId}")
    public ResponseEntity<?> getDetails(@PathVariable String merchantAndProductId) {
        MerchantAndProduct merchantAndProduct = merchantAndProductService.getDetails(merchantAndProductId);
        return new ResponseEntity<>(merchantAndProduct, HttpStatus.OK);
    }

    @PostMapping(path = "/get/product")
    public ResponseEntity<AllProductsByCategoryNameDTO> getProductDetails(@RequestHeader Map<String, String> headerss, @Valid @RequestBody ProductDisplayDTO productDisplayDTO) {
        headerss.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<AllProductsByCategoryNameDTO>(merchantAndProductService.getOneProduct(productDisplayDTO.getProductId(), productDisplayDTO.getMerchantAndProductId()), HttpStatus.OK);
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

    @PostMapping(path = "/decreaseQuantity")
    public ResponseEntity<String> decreaseMerchantProductQuantity(@Valid @RequestBody List<DecreaseMerchantProductQuantityDTO> decreaseMerchantProductQuantityDTOList) {
        System.out.println("object : " + decreaseMerchantProductQuantityDTOList.toString());

        boolean status = true;
        for (DecreaseMerchantProductQuantityDTO decreaseMerchantProductQuantityDTO : decreaseMerchantProductQuantityDTOList) {
            try {
                merchantAndProductService.changeQuantity(decreaseMerchantProductQuantityDTO);
            } catch (Exception ex) {
                status = false;
                System.out.println("Exception in decreaseQuantity : " + ex.getMessage());
            }
        }
        if (status) {
            return new ResponseEntity("Quantity decrease...", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity("Quantity not decrease...", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/dashbord/{merchantId}")
    public ResponseEntity<List<MerchantDashbordDTO>> getDashbord(@PathVariable(name = "merchantId") String merchantId) {
        System.out.println("================dashbord===========>" + merchantId);
        List<MerchantDashbordDTO> merchantDashbordDTOS = merchantAndProductService.getDashbord(merchantId);
        return new ResponseEntity<List<MerchantDashbordDTO>>(merchantDashbordDTOS, HttpStatus.OK);
    }


    @PutMapping(path = "/dashbord")
    public ResponseEntity<MessageDTO> getDashbord(@Valid @RequestBody DashbordUpdateDTO dashbordUpdateDTO) {

        return new ResponseEntity<MessageDTO>(merchantAndProductService.update(dashbordUpdateDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/getCartDetails/{merchantAndProductId}")
    public ResponseEntity<AllCartDetailsDTO> getCartDetails(@PathVariable(name = "merchantAndProductId") String merchantAndProductId) {
        AllCartDetailsDTO allCartDetailsDTOS = merchantAndProductService.getCartDetailsByMerchantAndProductId(merchantAndProductId);
        return new ResponseEntity<AllCartDetailsDTO>(allCartDetailsDTOS, HttpStatus.OK);
    }

    //TODO filter

    @PostMapping(path = "/display")
    public ResponseEntity<List<ProductsByAllMerchantDTO>> getCartDetails(@RequestBody Map<String, ?> map) {
        List<ProductsByAllMerchantDTO> productsByAllMerchantDTOS = merchantAndProductService.getAllMerchantByProductId(map.get("productId").toString());
        return new ResponseEntity<List<ProductsByAllMerchantDTO>>(productsByAllMerchantDTOS, HttpStatus.OK);
    }


    @GetMapping(path = "/get/merchant/{merchantAndProductId}")
    public ResponseEntity<MerchantAndProductDTO> getMerchantById(@PathVariable(name = "merchantAndProductId") String merchantAndProductId) {
        System.out.println("called!!!!!!!!!!!!!!!");
        MerchantAndProductDTO merchantAndProductDTO = new MerchantAndProductDTO();
        BeanUtils.copyProperties(merchantAndProductService.getMerchant(merchantAndProductId), merchantAndProductDTO);
        return new ResponseEntity<MerchantAndProductDTO>(merchantAndProductDTO, HttpStatus.OK);
    }

    ///Phani

    @PostMapping("/getDetailsFromProductId")
    public ResponseEntity<AllProductsByCategoryNameDTO> getDetailsFromProductId(@RequestBody ProductIdDto productIdDto){
        return new ResponseEntity<AllProductsByCategoryNameDTO>(merchantAndProductService.getDetailsFromProductId(productIdDto).get(0), HttpStatus.OK);
    }

}
