package com.coviam.team9.product.repository;

import com.coviam.team9.product.document.MerchantAndProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DecreaseQuantityRepository extends MongoRepository<MerchantAndProduct, String> {
}
