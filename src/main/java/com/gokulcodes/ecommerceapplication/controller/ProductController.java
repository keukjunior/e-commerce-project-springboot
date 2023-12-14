package com.gokulcodes.ecommerceapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokulcodes.ecommerceapplication.entity.Products;
import com.gokulcodes.ecommerceapplication.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Product Controller", description = "Create and retrieve Products")
@RequestMapping("/product")
public class ProductController {
    

    //define the field
    @Autowired
    private ProductService theProductService;


    @GetMapping("/allproducts")
    public ResponseEntity<List<Products>>showProducts(){
        List<Products> products = theProductService.showAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/id/{id}")
        public Optional<Products> getProductById(@PathVariable long id){
            return theProductService.getProductById(id);
        }

     @PostMapping("/create")   
     public Products addProducts(@RequestBody Products product){
        // also just incase they pass an id in json ... set id to  0 
        //this is to forces a save new item ... insetead of update
       product.setId((long)0);
       Products theProduct = theProductService.save(product);
       return theProduct;

     }  
     @PutMapping("/update")
        public Products updateProducts(@RequestBody Products theProduct){
            Products product = theProductService.save(theProduct);

            return product;
        }
        
      @DeleteMapping("/remove/{id}")
      public ResponseEntity<String> removeTheProduct(@PathVariable long id){
          theProductService.removeProduct(id);
        return ResponseEntity.ok("Product Removed Successfully");
      }  
     
}
