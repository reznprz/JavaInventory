package com.laxmi.inventory.management.inventory.domain;

import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.Entity.PurchaseOrder;
import com.laxmi.inventory.management.inventory.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderDomain {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    public Page<PurchaseOrder> getAllPurchaseOrder(Pageable pageable){
        return purchaseOrderRepository.getAllPurchaseOrder(pageable);
    }

    public PurchaseOrder createPurchaseOrder(Long staffId, PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.createPurchaseOrder(staffId, purchaseOrder);
    }

    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.updatePurchaseOrder(id,purchaseOrder);
    }

    public Boolean deletePurchaseOrder(Long id){
        return purchaseOrderRepository.deletePurchaseOrder(id);
    }

    public Boolean deletePurchaseOrderById(Long id){
        return purchaseOrderRepository.deletePurchaseOrderById(id);
    }
}
