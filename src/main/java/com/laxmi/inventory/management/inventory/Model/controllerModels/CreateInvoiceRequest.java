package com.laxmi.inventory.management.inventory.Model.controllerModels;


import com.laxmi.inventory.management.inventory.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateInvoiceRequest {

    private Customer customer;
    private List<Integer> productIds;
    private String discount;
    private double totalPrice;
}
