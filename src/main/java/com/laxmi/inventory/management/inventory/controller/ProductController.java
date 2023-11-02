//package com.laxmi.inventory.management.inventory.controller;
//
//import com.laxmi.inventory.management.inventory.Entity.Product;
//import com.laxmi.inventory.management.inventory.domain.ProductDomain;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/product")
//public class ProductController {
//
//    @Autowired
//    ProductDomain productDomain;
//
//    @GetMapping("/category/{categoryId}/products")
//    private Page<Product> getAllProductsByCategoryId(@PathVariable("categoryId") Long id, Pageable pageable) {
//        return productDomain.getAllProductsByCategoryId(id, pageable);
//    }
//
//    @PostMapping("/category/{categoryId}/products")
//    private Product createCategory(@PathVariable("categoryId") Long id, @RequestBody Product product) {
//        return productDomain.createProduct(id, product);
//    }
//
//    @PutMapping("/category/{categoryId}/products/{productId}")
//    private Product updateProduct(@PathVariable("categoryId") Long categoryId, @PathVariable("productId") Long productId, @RequestBody Product product) {
//        return productDomain.updateProduct(categoryId, productId, product);
//    }
//
//    @DeleteMapping("/category/{categoryId}/products/{productId}")
//    private Boolean deleteProduct(@PathVariable("categoryId") Long categoryId, @PathVariable("productId") Long productId) {
//        return productDomain.deleteProduct(categoryId, productId);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    private ResponseEntity<Boolean> deleteProductById(@PathVariable("id") Long id){
//        return new ResponseEntity<>(productDomain.deleteProductById(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/allProducts")
//    private ResponseEntity<List<Product>> getAllProducts(){
//        return new ResponseEntity<>(productDomain.getAllProduct(),HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/ByCategoryId/{id}")
//    private ResponseEntity<Boolean> deleteByCategoryId(@PathVariable("id") Long id){
//        return new ResponseEntity<>(productDomain.deleteByCategoryId(id), HttpStatus.OK);
//    }
//
//}