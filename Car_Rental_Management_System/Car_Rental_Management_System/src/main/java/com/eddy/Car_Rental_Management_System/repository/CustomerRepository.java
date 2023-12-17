package com.eddy.Car_Rental_Management_System.repository;

import com.eddy.Car_Rental_Management_System.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByUsernameAndPassword(String username, String password );
}
