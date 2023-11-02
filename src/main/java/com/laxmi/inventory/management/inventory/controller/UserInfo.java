package com.laxmi.inventory.management.inventory.controller;

import com.laxmi.inventory.management.inventory.Model.Customer;
import com.laxmi.inventory.management.inventory.service.ICustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/userInfo")
public class UserInfo {

    @Autowired
    ICustomerInfo customerService;

    @GetMapping("/CustomerInfo")
    private ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            return new ResponseEntity<>(customerService.getCustomerList(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
