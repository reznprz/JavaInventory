package com.laxmi.inventory.management.inventory.Service;

import com.laxmi.inventory.management.inventory.Model.Customer;
import com.laxmi.inventory.management.inventory.Model.Invoice;
import com.laxmi.inventory.management.inventory.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {

    InvoiceService invoiceService;

    CustomerService customerService;

    public CheckoutService(InvoiceService invoiceService,
                           CustomerService customerService) {
        this.invoiceService = invoiceService;
        this.customerService = customerService;
    }

    public void processCheckout(Customer customer, List<Integer> productIds, String discountPercentage, double totalAmount) {
        try {
            int cusId = customerExistsAndInsert(customer);

            Invoice invoice = invoiceBuilder(cusId, discountPercentage, totalAmount);

            invoiceService.createInvoice(invoice, productIds);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static Invoice invoiceBuilder(int cusId, String discountPercentage, double totalAmount) {
        Invoice invoice = new Invoice();
        invoice.setId(ServiceUtils.generateUniqueNumber());
        invoice.setCustomerId(cusId);
        invoice.setDiscount(Double.parseDouble(discountPercentage.replace("%", "")));
        invoice.setTotalAmount(calculateDiscount(totalAmount));
        invoice.setAmountBeforeDiscount(totalAmount);
        return invoice;
    }

    private int customerExistsAndInsert(Customer customer) {
        Integer cusId = 0;
        if (!customerService.customerExists(customer)) {
            customerService.createCustomer(customer);
        } else {
            cusId = customerService.getCustomerByEmail(customer.getEmail());
        }

        return cusId;
    }

    private static double calculateDiscount(double amount){

        Double totalAmountAfterDiscount = 0.0;

        if(amount <= 1000){
            totalAmountAfterDiscount = ServiceUtils.calculateDiscountedAmount( "5%", amount);
        }
        else if (amount >= 1000){
            totalAmountAfterDiscount = ServiceUtils.calculateDiscountedAmount("10%", amount);
        }

        return totalAmountAfterDiscount;
    }
}
