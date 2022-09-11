package com.laxmi.inventory.management.inventory.domain;

import com.laxmi.inventory.management.inventory.Entity.PurchaseOrder;
import com.laxmi.inventory.management.inventory.Entity.PurchaseOrderLineItem;
import com.laxmi.inventory.management.inventory.Model.CreatePurchaseOrderLineItemRequest;
import com.laxmi.inventory.management.inventory.Model.OrderLineItem;
import com.laxmi.inventory.management.inventory.repositories.PurchaseOrderLineItemRepository;
import com.laxmi.inventory.management.inventory.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderLineItemDomain {

    @Autowired
    PurchaseOrderLineItemRepository purchaseOrderLineItemRepository;

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    public List<OrderLineItem> getAllProductsByPurchaseOrderId(Long purchaseOrderId) {

        List<PurchaseOrderLineItem> purchaseOrderLineItems =purchaseOrderLineItemRepository.getAllOrderLineItemByPurchaseOrderId(purchaseOrderId);
        List<OrderLineItem> orderLineItemList = new ArrayList<>();
        for(PurchaseOrderLineItem lineItemDetail : purchaseOrderLineItems){
            OrderLineItem item = new OrderLineItem();
            item.setItemQuantity(lineItemDetail.getItemQuantity());
            item.setItemName(lineItemDetail.getItemName());
            item.setSku(lineItemDetail.getSku());
            item.setPoLineItemId(lineItemDetail.getPoLineItemId());
            item.setItemUnitDiscount(lineItemDetail.getItemUnitDiscount());
            item.setCreatedDate(lineItemDetail.getCreatedDate());
            item.setItemUnitPrice(lineItemDetail.getItemUnitPrice());
            orderLineItemList.add(item);
        }
        return orderLineItemList;
    }

    public PurchaseOrderLineItem createPOOrderLineItem(Long purchaseOrderId, Long productId,
                                                       PurchaseOrderLineItem purchaseOrderLineItem) {
        return purchaseOrderLineItemRepository.createPOOrderLineItem(purchaseOrderId, productId, purchaseOrderLineItem);
    }

    public OrderLineItem updatePOOrderLineItem(Long purchaseOrderId,
                                                       Long poOrderLineItemId, PurchaseOrderLineItem poLineItemRequested) {
        PurchaseOrderLineItem lineItemDetail =
        purchaseOrderLineItemRepository.updatePOOrderLineItem(purchaseOrderId, poOrderLineItemId, poLineItemRequested);
        OrderLineItem item = new OrderLineItem();
        item.setItemQuantity(lineItemDetail.getItemQuantity());
        item.setItemName(lineItemDetail.getItemName());
        item.setSku(lineItemDetail.getSku());
        item.setPoLineItemId(lineItemDetail.getPoLineItemId());
        item.setItemUnitDiscount(lineItemDetail.getItemUnitDiscount());
        item.setCreatedDate(lineItemDetail.getCreatedDate());
        item.setItemUnitPrice(lineItemDetail.getItemUnitPrice());
        return item;
    }

    public List<OrderLineItem> getAllPOOrderLineItem() {

        List<PurchaseOrderLineItem> purchaseOrderLineItemList = purchaseOrderLineItemRepository.getAllPOOrderLineItem();
        List<OrderLineItem> orderLineItemList = new ArrayList<>();
        for(PurchaseOrderLineItem lineItemDetail : purchaseOrderLineItemList){
            OrderLineItem item = new OrderLineItem();
            item.setItemQuantity(lineItemDetail.getItemQuantity());
            item.setItemName(lineItemDetail.getItemName());
            item.setSku(lineItemDetail.getSku());
            item.setPoLineItemId(lineItemDetail.getPoLineItemId());
            item.setItemUnitDiscount(lineItemDetail.getItemUnitDiscount());
            item.setCreatedDate(lineItemDetail.getCreatedDate());
            item.setItemUnitPrice(lineItemDetail.getItemUnitPrice());
            orderLineItemList.add(item);
        }
        return orderLineItemList;
    }

    public Boolean deleteByProductOrderId(Long id) {

        return purchaseOrderLineItemRepository.deleteByProductOrderId(id);
    }

    public String createPurchaseOrderLineItemRequest(CreatePurchaseOrderLineItemRequest request) {

        try {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setItemDiscount(request.getItemDiscount());
            purchaseOrder.setStatus(request.getStatus());
            purchaseOrder.setTax(request.getTax());
            purchaseOrder.setTotalPrice(request.getTotalPrice());
            purchaseOrder.setType(request.getType());
            purchaseOrder.setSubTotalPrice(request.getSubTotalPrice());

            PurchaseOrder purchaseOrderEntity = purchaseOrderRepository.createPurchaseOrder(request.getStaffId(), purchaseOrder);

            for (OrderLineItem lineItemDetail : request.getPoLineItemList()) {
                PurchaseOrderLineItem poLineItem = new PurchaseOrderLineItem();

                poLineItem.setItemUnitPrice(lineItemDetail.getItemUnitPrice());
                poLineItem.setCreatedDate(lineItemDetail.getCreatedDate());
                poLineItem.setItemName(lineItemDetail.getItemName());
                poLineItem.setSku(lineItemDetail.getSku());
                poLineItem.setItemUnitPrice(lineItemDetail.getItemUnitPrice());
                poLineItem.setItemUnitDiscount(lineItemDetail.getItemUnitDiscount());
                poLineItem.setItemQuantity(lineItemDetail.getItemQuantity());

                purchaseOrderLineItemRepository.
                        createPOOrderLineItem(purchaseOrderEntity.getId(), lineItemDetail.getProductId(), poLineItem);
            }

            return "added";

        } catch (Exception e) {
            return e.getLocalizedMessage();
        }

    }

}
