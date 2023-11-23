package com.laxmi.inventory.management.inventory.Service;

import com.laxmi.inventory.management.inventory.Model.Invoice;
import com.laxmi.inventory.management.inventory.mySqlRepository.SQLRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    SQLRepository sqlRepository;

    public InvoiceService(SQLRepository sqlRepository) {
        this.sqlRepository = sqlRepository;
    }

    public void createInvoice(Invoice invoice, List<Integer> productsIDs) {
        try {
            if (!sqlRepository.invoiceExists(invoice.getId())) {
                sqlRepository.createInvoice(invoice);
            }

            sqlRepository.createInvoiceProduct(invoice.getId(), productsIDs);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
