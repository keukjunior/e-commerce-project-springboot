package com.gokulcodes.ecommerceapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokulcodes.ecommerceapplication.entity.Products;
import com.gokulcodes.ecommerceapplication.repository.ProductRepository;
import com.gokulcodes.ecommerceapplication.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository theProductRepository;

    @Override
    public List<Products> showAllProducts() {
       
        return theProductRepository.findAll();
    }

    @Override
    public Optional<Products> getProductById(Long id) {
     
        return theProductRepository.findById(id);
    }

    @Override
    public Products save(Products products) {
      
        return theProductRepository.save(products);
    }

    @Override
    public void removeProduct(Long id) {
        theProductRepository.deleteById(id);
        
    }
    
}
