package com.coviam.team9.product.repository;

import com.coviam.team9.product.document.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "category",path = "category")
public interface CategoryRepository extends MongoRepository<Category, String> {
}
