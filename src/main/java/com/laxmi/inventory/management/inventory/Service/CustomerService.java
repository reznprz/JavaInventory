package com.laxmi.inventory.management.inventory.Service;

import com.laxmi.inventory.management.inventory.Model.Customer;
import com.laxmi.inventory.management.inventory.mySqlRepository.SQLRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    SQLRepository sqlRepository;

    public CustomerService(SQLRepository sqlRepository) {
        this.sqlRepository = sqlRepository;
    }

    public List<Customer> getAllCustomers() {
        return sqlRepository.getAllCustomers();
    }

    public Customer getCustomerById(Long cusId) {
        return sqlRepository.getCustomerById(cusId);
    }

    public boolean customerExists(Customer customer) {
        return sqlRepository.customerExists(customer.getEmail(), customer.getFirstName());
    }

    public void createCustomer(Customer customer) {
        sqlRepository.createCustomer(customer);
    }

    public Integer getCustomerByEmail(String email) {
        return sqlRepository.getCustomerByEmail(email);
    }

}
