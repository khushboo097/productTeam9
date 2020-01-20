package com.coviam.team9.product.service.impl;

import com.coviam.team9.product.document.Category;
import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.dto.AllProductsByCategoryNameDTO;
import com.coviam.team9.product.repository.CategoryRepository;
import com.coviam.team9.product.repository.MerchantAndProductRepository;
import com.coviam.team9.product.repository.ProductRepository;
import com.coviam.team9.product.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MerchantAndProductRepository merchantAndProductRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<AllProductsByCategoryNameDTO> getAllProductsByRating() {

        final List<Category> listCategory = categoryRepository.findAll();
        List<AllProductsByCategoryNameDTO> returnAllProductsByCategoryNameDTO = new ArrayList<AllProductsByCategoryNameDTO>();

        for (Category category : listCategory) {
            List<AllProductsByCategoryNameDTO> byCategoryName = productRepository.findByCategoryNameOrderByProductRating(category.getCategoryName());

            int count = 0;
            for (AllProductsByCategoryNameDTO productsByCategoryNameDTO : byCategoryName) {
                productsByCategoryNameDTO.setProductId(productsByCategoryNameDTO.get_id());
                MerchantAndProduct merchantAndProduct = null;
                List<MerchantAndProduct> all = merchantAndProductRepository.findByProductIdOrderBySellingPrice(productsByCategoryNameDTO.getProductId());
                System.out.println(productsByCategoryNameDTO.get_id() + "==>" + all.toString());


                if (!CollectionUtils.isEmpty(all)) {
                    for (MerchantAndProduct merchantAndProduct1 : all) {
                        System.out.println("***>" + merchantAndProduct1);
                        merchantAndProduct = merchantAndProduct1;
                        productsByCategoryNameDTO.setMerchantAndProductId(merchantAndProduct1.getMerchantAndProductId());
                        productsByCategoryNameDTO.setMerchantId(merchantAndProduct1.getMerchantId());
                        productsByCategoryNameDTO.setSellingPrice(merchantAndProduct1.getSellingPrice());
                        AllProductsByCategoryNameDTO obj = new AllProductsByCategoryNameDTO();
                        BeanUtils.copyProperties(productsByCategoryNameDTO, obj);
                        returnAllProductsByCategoryNameDTO.add(obj);
                        count++;
                        if (count == 2) {
                            break;
                        }
                    }
                }
            }
        }


        return returnAllProductsByCategoryNameDTO;
    }
}
