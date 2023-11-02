//package com.laxmi.inventory.management.inventory.repositories;
//
//import com.laxmi.inventory.management.inventory.Entity.Product;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Repository
//@Transactional
//public interface IProductRepository extends JpaRepository<Product, Long> {
//    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
//    Optional<Product> findByIdAndCategoryId(Long productId, Long categoryId);
//    @Transactional
//    void deleteByCategoryId(Long productId);
//    @Modifying()
//    @Query(value = "DELETE FROM product WHERE product_id= :productId", nativeQuery = true)
//    void deleteProduct(@Param("productId") Long productId);
//}
