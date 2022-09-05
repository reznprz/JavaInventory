package com.laxmi.inventory.management.inventory.repositories;

import com.laxmi.inventory.management.inventory.Entity.Product;
import com.laxmi.inventory.management.inventory.Entity.Staff;
import com.laxmi.inventory.management.inventory.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    IProductRepository productRepository;


    public Page<Product> getAllProdcutsByCategoryId(Long categoryId,
                                                Pageable pageable) {
        return productRepository.findByCategoryId(categoryId, pageable);
    }


    public Product createProduct( Long categoryId,
                                  Product product) {
        return categoryRepository.findById(categoryId).map(category -> {
            product.setCategory(category);
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("categoryId " + categoryId + " not found"));
    }


    public Product updateProduct(Long categoryId,
                                  Long productId,
                                 Product productRequested) {
        if(!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("CategoryId " + categoryId + " not found");
        }
        return productRepository.findById(productId).map(product -> {
            product.setProductDescription(productRequested.getProductDescription());
            product.setProductPrice(productRequested.getProductPrice());
            product.setProductQuantity(productRequested.getProductQuantity());
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("ProductId " + productRequested + "not found"));
    }


    public Boolean deleteProductByCategoryID(Long categoryId,
                                            Long productId) {
        return productRepository.findByIdAndCategoryId(productId, categoryId).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId + " and CategoryId " + categoryId));
    }

    public Boolean deleteProductById(Long id){

        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Product> getAllProduct(){

        List<Product> productList = productRepository.findAll();

        return productList;

    }
}
