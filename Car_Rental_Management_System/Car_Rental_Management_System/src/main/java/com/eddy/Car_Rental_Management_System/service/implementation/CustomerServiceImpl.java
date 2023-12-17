package com.eddy.Car_Rental_Management_System.service.implementation;

import com.eddy.Car_Rental_Management_System.model.Customer;
import com.eddy.Car_Rental_Management_System.repository.CustomerRepository;
import com.eddy.Car_Rental_Management_System.service.CustomerService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService1 {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer registerCustomer(Customer customer) {
        if (customer.getUsername() == null || customer.getPassword() == null) {
            return null;
        } else {
            return customerRepository.save(customer);
        }
    }

    @Override
    public Customer authenticate(Customer customer) {
        return customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword()).orElse(null);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public List<Customer> customerList() {
        return null;
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


}

