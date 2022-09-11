package com.laxmi.inventory.management.inventory.repositories;

import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.Entity.PurchaseOrder;
import com.laxmi.inventory.management.inventory.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PurchaseOrderRepository {

    @Autowired
    IPurchaseOrder purchaseOrderRepo;

    @Autowired
    IstaffRepository staffRepository;

    public Page<PurchaseOrder> getAllPurchaseOrder(Pageable pageable){
        return purchaseOrderRepo.findAll(pageable);
    }

    public Optional<PurchaseOrder> findByPurchaseOrderId(Long purchaseOrderId){
        return purchaseOrderRepo.findById(purchaseOrderId);
    }

    public PurchaseOrder createPurchaseOrder(Long staffId,PurchaseOrder purchaseOrder){
        return staffRepository.findById(staffId).map(staff -> {
            purchaseOrder.setStaff(staff);
            return purchaseOrderRepo.save(purchaseOrder);
        }).orElseThrow(()-> new ResourceNotFoundException("StaffId : "+ staffId + " not found"));
    }

    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder){
        return purchaseOrderRepo.findById(id).map(purchaseOrder1 -> {
            purchaseOrder1.setItemDiscount(purchaseOrder.getItemDiscount());
            purchaseOrder1.setTax(purchaseOrder.getTax());
            purchaseOrder1.setStatus(purchaseOrder.getStatus());
            purchaseOrder1.setOrderId(purchaseOrder.getOrderId());
            purchaseOrder1.setTotalPrice(purchaseOrder.getTotalPrice());
            purchaseOrder1.setSubTotalPrice(purchaseOrder.getSubTotalPrice());
            return purchaseOrderRepo.save(purchaseOrder1);
        }).orElseThrow(()-> new ResourceNotFoundException("PurchaseOrder ID "+ id + "not found"));
    }

    public Boolean deletePurchaseOrder(Long id){
        return  purchaseOrderRepo.findById(id).map(purchaseOrder -> {
            purchaseOrderRepo.delete(purchaseOrder);
            return true;
        }).orElse(false);
    }
}
