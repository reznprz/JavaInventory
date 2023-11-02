//package com.laxmi.inventory.management.inventory.repositories;
//
//import com.laxmi.inventory.management.inventory.Entity.Product;
//import com.laxmi.inventory.management.inventory.Entity.PurchaseOrderLineItem;
//import com.laxmi.inventory.management.inventory.Exception.ResourceNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class PurchaseOrderLineItemRepository {
//
//    @Autowired
//    IPurchaseOrderLineItem purchaseOrderLineItemRepo;
//
//    @Autowired
//    IPurchaseOrder purchaseOrderRepo;
//
//    @Autowired
//    IProductRepository productRepository;
//
//    public List<PurchaseOrderLineItem> getAllOrderLineItemByPurchaseOrderId(Long purchaseOrderId) {
//        return purchaseOrderLineItemRepo.findByPurchaseOrderId(purchaseOrderId);
//    }
//
//    public PurchaseOrderLineItem createPOOrderLineItem(Long purchaseOrderId, Long productId,
//                                                       PurchaseOrderLineItem purchaseOrderLineItem) {
//        Optional<Product> product;
//        try {
//            product = productRepository.findById(productId);
//        } catch (Exception e) {
//            throw new ResourceNotFoundException("productId " + productId + " not found");
//        }
//        Optional<Product> finalProduct = product;
//
//        return purchaseOrderRepo.findById(purchaseOrderId).map(purchaseOrder -> {
//            purchaseOrderLineItem.setPurchaseOrder(purchaseOrder);
//            finalProduct.ifPresent(purchaseOrderLineItem::setProduct);
//            System.out.println(purchaseOrderLineItem);
//            return purchaseOrderLineItemRepo.save(purchaseOrderLineItem);
//        }).orElseThrow(() -> new ResourceNotFoundException("purchaseOrderId " + purchaseOrderId + " not found"));
//    }
//
//    public PurchaseOrderLineItem updatePOOrderLineItem(Long purchaseOrderId,
//                                                       Long poOrderLineItemId, PurchaseOrderLineItem poLineItemRequested) {
//        if (!purchaseOrderRepo.existsById(purchaseOrderId)) {
//            throw new ResourceNotFoundException("purchaseOrderId " + purchaseOrderId + " not found");
//        }
//
//        return purchaseOrderLineItemRepo.findById(poOrderLineItemId).map(poLineItem -> {
//            poLineItem.setItemName(poLineItemRequested.getItemName());
//            poLineItem.setItemQuantity(poLineItemRequested.getItemQuantity());
//            poLineItem.setItemUnitDiscount(poLineItemRequested.getItemUnitDiscount());
//            poLineItem.setItemUnitPrice(poLineItemRequested.getItemUnitPrice());
//            return purchaseOrderLineItemRepo.save(poLineItem);
//        }).orElseThrow(() -> new ResourceNotFoundException("poOrderLineItemId " + poOrderLineItemId + "not found"));
//    }
//
//    public List<PurchaseOrderLineItem> getAllPOOrderLineItem() {
//
//        return purchaseOrderLineItemRepo.findAll();
//
//    }
//
//    public Boolean deleteByProductOrderId(Long id) {
//        try {
//            purchaseOrderLineItemRepo.deletePurchaseOrderLineItem(id);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//}
