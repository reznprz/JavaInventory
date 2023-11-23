package com.laxmi.inventory.management.inventory.domain;

import com.laxmi.inventory.management.inventory.Entity.Product;
import com.laxmi.inventory.management.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDomain {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> getAllProductsByCategoryId(Long categoryId, Pageable pageable){
        return productRepository.getAllProductsByCategoryId(categoryId,pageable);
    }

    public Product createProduct(Long categoryId, Product product){
        return productRepository.createProduct(categoryId,product);
    }

    public Product updateProduct(Long categoryId, Long productId, Product product){
        return productRepository.updateProduct(categoryId,productId,product);
    }

    public Boolean deleteProduct(Long categoryId,
                                 Long productId) {
    return productRepository.deleteProductByCategoryID(categoryId,productId);
    }

    public Boolean deleteProductById(Long id){
        return productRepository.deleteProductById(id);
    }

    public List<Product> getAllProduct(){
        return productRepository.getAllProduct();
    }

    public Boolean deleteByCategoryId(Long id){
        return productRepository.deleteByCategoryId(id);
    }

    public void createProductIfNotExists(String productName, String productDescription,
                                          String imageUrl, Integer unitPrice,
                                          Integer quantityInStock, String sku, Long categoryId) {
        if (!productRepository.existsByProductName(productName)) {
            Product product = new Product();
            product.setProductName(productName);
            product.setProductDescription(productDescription);
            product.setImage_url(imageUrl);
            product.setProductUnitPrice(unitPrice);
            product.setProductUnitQuantityStock(quantityInStock);
            product.setSku(sku);
            product.setId(categoryId);
            productRepository.createProduct(categoryId, product);
        }
    }


}
