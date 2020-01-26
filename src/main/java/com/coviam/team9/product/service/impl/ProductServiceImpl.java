package com.coviam.team9.product.service.impl;

import com.coviam.team9.product.document.Product;
import com.coviam.team9.product.dto.AddProductDTO;
import com.coviam.team9.product.dto.Demo;
import com.coviam.team9.product.repository.ProductRepository;
import com.coviam.team9.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;


    private static final String TOPIC = "team9demo";


    @Autowired
    ProductRepository productRepository;

    @Override
    public AddProductDTO insertOrUpdate(Product product) {
        List<Product> productList = productRepository.findByProductNameAndDescriptionAndCategoryName(product.getProductName(), product.getDescription(), product.getCategoryName());
        AddProductDTO addProductDTO = new AddProductDTO();
        if (productList.size() > 0) {
            System.out.println("product is already registered.... ");
            addProductDTO.setProductId(productList.get(0).getProductId());
            addProductDTO.setMessage("product is already registered.... ");
            return addProductDTO;
        }

        final Product saveProduct = productRepository.save(product);
        addProductDTO.setProductId(saveProduct.getProductId());
        addProductDTO.setMessage("product is registered.... ");
        kafkaTemplate.send(TOPIC, saveProduct);
        return addProductDTO;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(String productId) {

        return productRepository.findById(productId).get();
    }
}
