package com.gokulcodes.ecommerceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gokulcodes.ecommerceapplication.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {
    
}
