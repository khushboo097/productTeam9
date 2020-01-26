package com.coviam.team9.product.repository;

import com.coviam.team9.product.document.MerchantAndProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantAndProductRepository extends MongoRepository<MerchantAndProduct, String> {
//    List<MerchantAndProduct> findByProductId(String id);

    List<MerchantAndProduct> findByProductIdOrderBySellingPrice(String id);

    List<MerchantAndProduct> findAllByMerchantId(String merchantId);

    List<MerchantAndProduct> findAllByProductId(String productId);

}
