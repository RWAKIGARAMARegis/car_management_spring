package com.eddy.Car_Rental_Management_System.service;

import com.eddy.Car_Rental_Management_System.model.Customer;

import java.util.List;

public interface CustomerService1 {
    Customer registerCustomer(Customer customer);
    Customer authenticate(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> customerList();

    Customer findCustomerById(Integer customerId);
    // Customer findCustomerById(Integer customer);
    List<Customer> getAllCustomers();
}
