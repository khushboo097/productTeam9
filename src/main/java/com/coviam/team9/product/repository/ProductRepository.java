package com.coviam.team9.product.repository;


import com.coviam.team9.product.document.Product;
import com.coviam.team9.product.dto.AllProductsByCategoryNameDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByProductNameAndDescriptionAndCategoryName(String productName, String description, String categoryName);

    List<AllProductsByCategoryNameDTO> findByCategoryName(String categoryName);

    List<AllProductsByCategoryNameDTO> findByCategoryNameOrderByProductRating(String categoryName);
}
