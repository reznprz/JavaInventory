//package com.laxmi.inventory.management.inventory.repositories;
//
//import com.laxmi.inventory.management.inventory.Entity.PurchaseOrderLineItem;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//@Transactional
//public interface IPurchaseOrderLineItem extends JpaRepository<PurchaseOrderLineItem, Long> {
//
//    List<PurchaseOrderLineItem> findByPurchaseOrderId(Long purchaseOrderId);
//
//    @Modifying()
//    @Query(value = "DELETE FROM purchase_order_line_item WHERE po_line_item_id= :poOrderLineItemId", nativeQuery = true)
//    void deletePurchaseOrderLineItem(@Param("poOrderLineItemId") Long poOrderLineItemId);
//
//}
