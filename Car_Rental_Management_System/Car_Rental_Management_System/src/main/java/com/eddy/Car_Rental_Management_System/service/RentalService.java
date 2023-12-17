package com.eddy.Car_Rental_Management_System.service;

import com.eddy.Car_Rental_Management_System.model.Rental;

import java.util.List;

public interface RentalService {
    List<Rental> getAllRentals();
    Rental getRentalById(int id);
    Rental rentCar(Rental rental);
    Rental returnCar(Rental rental);
    void deleteRental(int id);
}
