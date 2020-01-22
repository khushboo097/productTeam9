package com.coviam.team9.product.dto;

import com.coviam.team9.product.document.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoryDTO {
    private String _id;
    private String categoryName;
}