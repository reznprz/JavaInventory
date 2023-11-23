package com.laxmi.inventory.management.inventory.controller;


import com.laxmi.inventory.management.inventory.Entity.Product;
import com.laxmi.inventory.management.inventory.Model.controllerModels.CreateInvoiceRequest;
import com.laxmi.inventory.management.inventory.Service.CheckoutService;
import com.laxmi.inventory.management.inventory.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

    private final CheckoutService checkoutService;

    public InvoiceController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/create/invoice")
    private void createInvoice(@RequestBody CreateInvoiceRequest req) {
        checkoutService.processCheckout(req.getCustomer(), req.getProductIds(), req.getDiscount(), req.getTotalPrice());
    }
}
