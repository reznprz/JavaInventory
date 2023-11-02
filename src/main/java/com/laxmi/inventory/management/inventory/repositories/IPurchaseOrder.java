//package com.laxmi.inventory.management.inventory.repositories;
//
//import com.laxmi.inventory.management.inventory.Entity.PurchaseOrder;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//
//@Repository
//@Transactional
//public interface IPurchaseOrder extends JpaRepository<PurchaseOrder, Long> {
//    @Modifying()
//    @Query(value = "DELETE FROM purchase_order WHERE purchase_order_po_id= :poId", nativeQuery = true)
//    void deletePurchaseOrder(@Param("poId") Long poId);
//}
