package com.eddy.Car_Rental_Management_System.repository;

import com.eddy.Car_Rental_Management_System.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
