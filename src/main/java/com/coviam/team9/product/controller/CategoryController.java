package com.coviam.team9.product.controller;

import com.coviam.team9.product.document.Category;
import com.coviam.team9.product.document.MerchantAndProduct;
import com.coviam.team9.product.dto.AllProductsByCategoryNameDTO;
import com.coviam.team9.product.dto.CategoryDTO;
import com.coviam.team9.product.service.CategoryService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Category>> getAllCategory() {
        System.out.println("===========");
        return new ResponseEntity<List<Category>>(categoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        categoryService.save(category);
        return new ResponseEntity<Category>(category, HttpStatus.CREATED);

    }

    @GetMapping(path = "/getAllProductsByRating")
    public ResponseEntity<List<AllProductsByCategoryNameDTO>> getAllProductsByRating() {

        return new ResponseEntity<List<AllProductsByCategoryNameDTO>>(categoryService.getAllProductsByRating(), HttpStatus.OK);
    }

}
