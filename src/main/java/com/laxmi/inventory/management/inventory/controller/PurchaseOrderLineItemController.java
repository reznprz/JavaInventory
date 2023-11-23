package com.laxmi.inventory.management.inventory.controller;

import com.laxmi.inventory.management.inventory.Entity.PurchaseOrderLineItem;
import com.laxmi.inventory.management.inventory.Model.controllerModels.CreatePurchaseOrderLineItemRequest;
import com.laxmi.inventory.management.inventory.Model.OrderLineItem;
import com.laxmi.inventory.management.inventory.domain.PurchaseOrderLineItemDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderLineItem")
public class PurchaseOrderLineItemController {

    @Autowired
    PurchaseOrderLineItemDomain poLineItemDomain;

    @GetMapping("/getByPurchaseOrderId/{purchaseOrderId}/orderLineItem")
    private List<OrderLineItem> getAllProductsByPurchaseOrderId(@PathVariable("purchaseOrderId") Long id) {
        List<OrderLineItem> p = poLineItemDomain.getAllProductsByPurchaseOrderId(id);
        return p;
    }

    @PostMapping("/create/{purchaseOrderId}/{productId}")
    private PurchaseOrderLineItem createPOOrderLineItem(@PathVariable("purchaseOrderId") Long purchaseOrderId, @PathVariable("productId") Long productId, @RequestBody PurchaseOrderLineItem purchaseOrderLineItem) throws Exception {
        return poLineItemDomain.createPOOrderLineItem(purchaseOrderId, productId, purchaseOrderLineItem);
    }

    @PutMapping("/update/{purchaseOrderId}/{lineItemId}")
    public OrderLineItem updatePOOrderLineItem(@PathVariable("purchaseOrderId") Long purchaseOrderId, @PathVariable("lineItemId") Long poLineItemId, @RequestBody PurchaseOrderLineItem purchaseOrderLineItem) {
        return poLineItemDomain.updatePOOrderLineItem(purchaseOrderId, poLineItemId, purchaseOrderLineItem);
    }

    @GetMapping("/allOrderLineItems")
    public List<OrderLineItem> getAllPOOrderLineItem() {
        return poLineItemDomain.getAllPOOrderLineItem();
    }

    @DeleteMapping("/delete/byOrderLineItems/{id}")
    public Boolean deleteByProductOrderId(@PathVariable("id") Long id) {
        return poLineItemDomain.deleteByProductOrderId(id);
    }

    @PostMapping("/createPO")
    public String createPurchaseOrderLineItemRequest(@RequestBody CreatePurchaseOrderLineItemRequest request) {
        return poLineItemDomain.createPurchaseOrderLineItemRequest(request);
    }
}
