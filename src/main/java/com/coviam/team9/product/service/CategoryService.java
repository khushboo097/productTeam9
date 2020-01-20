package com.coviam.team9.product.service;


import com.coviam.team9.product.document.Category;
import com.coviam.team9.product.dto.AllProductsByCategoryNameDTO;

import java.util.List;

public interface CategoryService  {

    List<Category> getAll();

    void save(Category category);

    List<AllProductsByCategoryNameDTO> getAllProductsByRating();
}
