package com.eddy.Car_Rental_Management_System.repository;

import com.eddy.Car_Rental_Management_System.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
