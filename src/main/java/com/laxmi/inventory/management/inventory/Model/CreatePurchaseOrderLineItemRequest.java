package com.laxmi.inventory.management.inventory.Model;

import com.laxmi.inventory.management.inventory.Entity.PurchaseOrderLineItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePurchaseOrderLineItemRequest {

    private Long staffId;

    private float totalPrice;

    private float tax;

    private float itemDiscount;

    private String status;

    private float subTotalPrice;

    private String type;

    private List<OrderLineItem> poLineItemList;
}
