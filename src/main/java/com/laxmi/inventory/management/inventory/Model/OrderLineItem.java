package com.laxmi.inventory.management.inventory.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItem {

    private Long productId;

    private Long poLineItemId;

    private String createdDate;

    private String itemName;

    private int itemQuantity;

    private float itemUnitPrice;

    private float itemUnitDiscount;

    private String sku;
}
