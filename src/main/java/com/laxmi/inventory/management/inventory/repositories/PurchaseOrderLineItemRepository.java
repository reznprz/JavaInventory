package com.laxmi.inventory.management.inventory.repositories;

import com.laxmi.inventory.management.inventory.Entity.Product;
import com.laxmi.inventory.management.inventory.Entity.PurchaseOrderLineItem;
import com.laxmi.inventory.management.inventory.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseOrderLineItemRepository {

    @Autowired
    IPurchaseOrderLineItem purchaseOrderLineItemRepo;

    @Autowired
    IPurchaseOrder purchaseOrderRepo;

    @Autowired
    IProductRepository productRepository;

    public List<PurchaseOrderLineItem> getAllOrderLineItemByPurchaseOrderId(Long purchaseOrderId) {
        return purchaseOrderLineItemRepo.findByPurchaseOrderId(purchaseOrderId);
    }


    public PurchaseOrderLineItem createPOOrderLineItem(Long purchaseOrderId, Long productId,
                                                       PurchaseOrderLineItem purchaseOrderLineItem) {
        Optional<Product> product = null;
        try {
            product = productRepository.findById(productId);
        } catch (Exception e) {
            new ResourceNotFoundException("productId " + productId + " not found");
        }
        Optional<Product> finalProduct = product;
        return purchaseOrderRepo.findById(purchaseOrderId).map(purchaseOrder -> {
            purchaseOrderLineItem.setPurchaseOrder(purchaseOrder);
            purchaseOrderLineItem.setProduct(finalProduct.get());
            System.out.println(purchaseOrderLineItem);
            return purchaseOrderLineItemRepo.save(purchaseOrderLineItem);
        }).orElseThrow(() -> new ResourceNotFoundException("purchaseOrderId " + purchaseOrderId + " not found"));
    }


    public PurchaseOrderLineItem updatePOOrderLineItem(Long purchaseOrderId,
                                                       Long poOrderLineItemId, PurchaseOrderLineItem poLineItemRequested) {
        if (!purchaseOrderRepo.existsById(purchaseOrderId)) {
            throw new ResourceNotFoundException("purchaseOrderId " + purchaseOrderId + " not found");
        }

        Optional<PurchaseOrderLineItem> pp = purchaseOrderLineItemRepo.findById(poOrderLineItemId);

        return purchaseOrderLineItemRepo.findById(poOrderLineItemId).map(poLineItem -> {
            poLineItem.setItemName(poLineItemRequested.getItemName());
            poLineItem.setItemQuantity(poLineItemRequested.getItemQuantity());
            poLineItem.setItemUnitDiscount(poLineItemRequested.getItemUnitDiscount());
            poLineItem.setItemUnitPrice(poLineItemRequested.getItemUnitPrice());
            return purchaseOrderLineItemRepo.save(poLineItem);
        }).orElseThrow(() -> new ResourceNotFoundException("poOrderLineItemId " + poOrderLineItemId + "not found"));
    }

//
//    public Boolean deletePOOrderLineItemByCategoryID(Long categoryId,
//                                             Long productId) {
//        Optional<Product> p = productRepository.findByIdAndCategoryId(productId, categoryId);
//        Optional<Product> pp = productRepository.findById(productId);
//        productRepository.delete(pp.get());
//        return productRepository.findByIdAndCategoryId(productId, categoryId).map(product -> {
//            productRepository.delete(product);
//            return true;
//        }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId + " and CategoryId " + categoryId));
//    }

//    public Boolean deletePOOrderLineItemById(Long id){
//        Product r = new Product();
//        try{
//            productRepository.deleteProduct(id);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }

    public List<PurchaseOrderLineItem> getAllPOOrderLineItem() {

        List<PurchaseOrderLineItem> poOrderLineItemList = purchaseOrderLineItemRepo.findAll();

        return poOrderLineItemList;

    }

    public Boolean deleteByProductOrderId(Long id) {
        try {
            purchaseOrderLineItemRepo.deletePurchaseOrderLineItem(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public void craetePO(){
//        Optional<Product> product = null;
//        try {
//            product = productRepository.findById(productId);
//        } catch (Exception e) {
//            new ResourceNotFoundException("productId " + productId + " not found");
//        }
//
//
//        Product finalProduct = new Product();
//        finalProduct.setProductUnitPrice(product.get().getProductUnitPrice());
//        finalProduct.setId(product.get().getId());
//        finalProduct.setProductName(product.get().getProductName());
//        finalProduct.setProductDescription(product.get().getProductDescription());
//        finalProduct.setProductUnitQuantityStock(product.get().getProductUnitQuantityStock());
//        finalProduct.setProductUnitPrice(product.get().getProductUnitPrice());
//        finalProduct.setSku(product.get().getSku());
//        finalProduct.setImage_url(product.get().getImage_url());
//        finalProduct.setCategory(product.get().getCategory());
//        try{
//            Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findById(purchaseOrderId);
//            purchaseOrderLineItem.setPurchaseOrder(purchaseOrder.get());
//            purchaseOrderLineItem.setProduct(finalProduct);
//            System.out.println(purchaseOrderLineItem);
//            return purchaseOrderLineItemRepo.save(purchaseOrderLineItem);
//        }catch (Exception e){
//            purchaseOrderRepo.deletePurchaseOrder(purchaseOrderId);
//            throw new ResourceNotFoundException("purchaseOrderId " + purchaseOrderId + " not found");
//        }
//
//    }
}
