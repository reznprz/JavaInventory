package com.laxmi.inventory.management.inventory.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {

    private int id;
    private int customerId;
    private double amountBeforeDiscount;
    private double discount;
    private double totalAmount;
    private Date createdDate;
    private Date updatedDate;
    private String updatedSource;
}
