package com.coviam.team9.product.service.impl;

import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.document.Product;
import com.coviam.team9.product.dto.AllProductsByCategoryNameDTO;
import com.coviam.team9.product.dto.DecreaseMerchantProductQuantityDTO;
import com.coviam.team9.product.dto.ProductGetDTO;
import com.coviam.team9.product.repository.MerchantAndProductRepository;
import com.coviam.team9.product.repository.ProductRepository;
import com.coviam.team9.product.service.MerchantAndProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class merchantAndProductServiceImpl implements MerchantAndProductService {
    @Autowired
    MerchantAndProductRepository merchantAndProductRepository;


    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(MerchantAndProduct merchantAndProduct) {
        merchantAndProductRepository.save(merchantAndProduct);
    }

    @Override
    public int changeQuantity(DecreaseMerchantProductQuantityDTO decreaseMerchantProductQuantityDTO) {

        Optional<MerchantAndProduct> merchantAndProduct = merchantAndProductRepository.findById(decreaseMerchantProductQuantityDTO.getMerchantAndProductId());

        int quantity;
        if (merchantAndProduct != null) {
            quantity = merchantAndProduct.get().getQuantity();
            if (quantity == merchantAndProduct.get().getTotalSellingQuantity()) {
                return -1;
            }
            if (decreaseMerchantProductQuantityDTO.getQuantity() + merchantAndProduct.get().getTotalSellingQuantity() > quantity) {
                return (quantity - merchantAndProduct.get().getTotalSellingQuantity());
            }
        }
        merchantAndProduct.get().setTotalSellingQuantity(merchantAndProduct.get().getTotalSellingQuantity() + decreaseMerchantProductQuantityDTO.getQuantity());
        double revenue = decreaseMerchantProductQuantityDTO.getQuantity() * merchantAndProduct.get().getSellingPrice();
        merchantAndProduct.get().setRevenue(merchantAndProduct.get().getRevenue() + revenue);
        MerchantAndProduct merchantAndProductEditedObj = merchantAndProduct.get();
        merchantAndProductRepository.save(merchantAndProductEditedObj);
        return 0;
    }

    @Override
    public List<AllProductsByCategoryNameDTO> getProductsByCategoryNameAndMerchantRating(String categoryName) {

        final List<AllProductsByCategoryNameDTO> byCategoryName = productRepository.findByCategoryName(categoryName);

        //phone rating
        //phone price h,l
        List<AllProductsByCategoryNameDTO> returnAllProductsByCategoryNameDTO = new ArrayList<AllProductsByCategoryNameDTO>();

        for (AllProductsByCategoryNameDTO productsByCategoryNameDTO : byCategoryName) {
            productsByCategoryNameDTO.setProductId(productsByCategoryNameDTO.get_id());
            MerchantAndProduct merchantAndProduct = null;
            List<MerchantAndProduct> all = merchantAndProductRepository.findByProductIdOrderBySellingPrice(productsByCategoryNameDTO.getProductId());
            if (!CollectionUtils.isEmpty(all)) {

                merchantAndProduct = all.get(0);
                productsByCategoryNameDTO.setMerchantAndProductId(merchantAndProduct.getMerchantAndProductId());
                productsByCategoryNameDTO.setMerchantId(merchantAndProduct.getMerchantId());
                productsByCategoryNameDTO.setSellingPrice(merchantAndProduct.getSellingPrice());
                returnAllProductsByCategoryNameDTO.add(productsByCategoryNameDTO);
            }
        }
        return returnAllProductsByCategoryNameDTO;
    }

    @Override
    public AllProductsByCategoryNameDTO getOneProduct(String productId, String merchantAndProductId) {
        final Optional<Product> byId = productRepository.findById(productId);
        Optional<MerchantAndProduct> obj = merchantAndProductRepository.findById(merchantAndProductId);
        AllProductsByCategoryNameDTO allProductsByCategoryNameDTO = new AllProductsByCategoryNameDTO();
        allProductsByCategoryNameDTO.setProductId(byId.get().getProductId());
        allProductsByCategoryNameDTO.setMerchantId(obj.get().getMerchantId());
        allProductsByCategoryNameDTO.setProductName(byId.get().getProductName());
        allProductsByCategoryNameDTO.set_id(byId.get().getProductId());
        allProductsByCategoryNameDTO.setDescription(byId.get().getDescription());
        allProductsByCategoryNameDTO.setProductRating(byId.get().getProductRating());
        allProductsByCategoryNameDTO.setCategoryName(byId.get().getCategoryName());
        allProductsByCategoryNameDTO.setPrice(byId.get().getPrice());
        allProductsByCategoryNameDTO.setUrl1(byId.get().getUrl1());
        allProductsByCategoryNameDTO.setUrl2(byId.get().getUrl3());
        allProductsByCategoryNameDTO.setUrl3(byId.get().getUrl2());
        allProductsByCategoryNameDTO.setMerchantAndProductId(merchantAndProductId);
        allProductsByCategoryNameDTO.setSellingPrice(obj.get().getSellingPrice());
        return allProductsByCategoryNameDTO;
    }

}
