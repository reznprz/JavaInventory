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
public class SalesTransaction {

    private int id;
    private int customerId;
    private int invoiceId;
    private Date transactionDate;
}
