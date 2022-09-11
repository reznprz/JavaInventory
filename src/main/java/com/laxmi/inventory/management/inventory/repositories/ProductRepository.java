package com.laxmi.inventory.management.inventory.repositories;

import com.laxmi.inventory.management.inventory.Entity.Product;
import com.laxmi.inventory.management.inventory.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    IProductRepository productRepository;


    public Page<Product> getAllProductsByCategoryId(Long categoryId,
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
            product.setProductUnitPrice(productRequested.getProductUnitPrice());
            product.setProductUnitQuantityStock(productRequested.getProductUnitQuantityStock());
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("ProductId " + productRequested + "not found"));
    }


    public Boolean deleteProductByCategoryID(Long categoryId,
                                            Long productId) {
        Optional<Product> p = productRepository.findByIdAndCategoryId(productId, categoryId);
        Optional<Product> pp = productRepository.findById(productId);
        productRepository.delete(pp.get());
        return productRepository.findByIdAndCategoryId(productId, categoryId).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId + " and CategoryId " + categoryId));
    }

    public Boolean deleteProductById(Long id){
        Product r = new Product();
        try{
            productRepository.deleteProduct(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Product> getAllProduct(){

        List<Product> productList = productRepository.findAll();

        return productList;

    }

    public Boolean deleteByCategoryId(Long id){
        try{
            productRepository.deleteByCategoryId(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
