package com.laxmi.inventory.management.inventory.controller;

import com.laxmi.inventory.management.inventory.Entity.PurchaseOrder;
import com.laxmi.inventory.management.inventory.domain.PurchaseOrderDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderDomain purchaseOrderDomain;

    @GetMapping("/allPurchaseOrder")
    private Page<PurchaseOrder> getAllCategory(Pageable pageable){
        return purchaseOrderDomain.getAllPurchaseOrder(pageable);
    }

    @PostMapping("/create/{staffId}")
    private PurchaseOrder createCategory(@PathVariable("staffId") Long staffId, @RequestBody PurchaseOrder purchaseOrder){
        return purchaseOrderDomain.createPurchaseOrder(staffId, purchaseOrder);
    }

    @PutMapping("/update/{id}")

    private PurchaseOrder updateCategory(@PathVariable("id") Long id, @RequestBody PurchaseOrder purchaseOrder){
        return purchaseOrderDomain.updatePurchaseOrder(id,purchaseOrder);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long id){
        try{
            purchaseOrderDomain.deletePurchaseOrder(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteByPoId/{id}")
    public Boolean deletePurchaseOrderById(@PathVariable("id") Long id){
        return purchaseOrderDomain.deletePurchaseOrderById(id);
    }

}
