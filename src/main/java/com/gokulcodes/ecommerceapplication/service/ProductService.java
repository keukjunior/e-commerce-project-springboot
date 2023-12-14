package com.gokulcodes.ecommerceapplication.service;

import java.util.List;
import java.util.Optional;

import com.gokulcodes.ecommerceapplication.entity.Products;

public interface ProductService {
    //read all
    List<Products> showAllProducts();

    //read by id
    Optional<Products> getProductById(Long id);

    //create and update
    Products save(Products products);

    //remove the product
    void removeProduct(Long id);

    
}
