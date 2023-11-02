package com.laxmi.inventory.management.inventory.service;

import com.laxmi.inventory.management.inventory.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerInfo {

    List<Customer> getCustomerList();
}
