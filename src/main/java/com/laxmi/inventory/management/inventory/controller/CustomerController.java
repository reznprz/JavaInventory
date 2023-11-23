package com.laxmi.inventory.management.inventory.controller;


import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.Model.Customer;
import com.laxmi.inventory.management.inventory.Model.DBRow;
import com.laxmi.inventory.management.inventory.Service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/getAllCustomer")
    private List<Customer> getAllCustomer(Pageable pageable){
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer/{id}")
    private Customer getCustomerById(@PathVariable("id") Long id){
        return customerService.getCustomerById(id);
    }
}
