package com.laxmi.inventory.management.inventory.service;

import com.laxmi.inventory.management.inventory.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerInfo implements ICustomerInfo {

    public List<Customer> getCustomerList() {

        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1L, "John", "Doe", "john.doe@example.com", "123 Elm St", "555-1010"));
        customers.add(new Customer(2L, "Jane", "Roe", "jane.roe@example.com", "456 Oak St", "555-2020"));
        customers.add(new Customer(3L, "Jim", "Beam", "jim.beam@example.com", "789 Pine St", "555-3030"));
        customers.add(new Customer(4L, "Jill", "Hill", "jill.hill@example.com", "101 Maple St", "555-4040"));
        customers.add(new Customer(5L, "Jake", "Lake", "jake.lake@example.com", "202 Birch St", "555-5050"));
        customers.add(new Customer(6L, "Julia", "Miles", "julia.miles@example.com", "303 Cedar St", "555-6060"));
        customers.add(new Customer(7L, "Jason", "Court", "jason.court@example.com", "404 Spruce St", "555-7070"));
        customers.add(new Customer(8L, "Jasmine", "Font", "jasmine.font@example.com", "505 Redwood St", "555-8080"));
        customers.add(new Customer(9L, "Jeremy", "Strong", "jeremy.strong@example.com", "606 Walnut St", "555-9090"));
        customers.add(new Customer(10L, "Jessica", "Song", "jessica.song@example.com", "707 Cherry St", "555-1011"));

        return customers;
    }

}
