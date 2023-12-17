package com.eddy.Car_Rental_Management_System.service.implementation;

import com.eddy.Car_Rental_Management_System.model.Rental;
import com.eddy.Car_Rental_Management_System.repository.RentalRepository;
import com.eddy.Car_Rental_Management_System.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental getRentalById(int id) {
        Optional<Rental> optionalRental = rentalRepository.findById(id);
        return optionalRental.orElse(null);
    }

    @Override
    public Rental rentCar(Rental rental) {
        // Perform any necessary business logic before saving
        return rentalRepository.save(rental);
    }

    @Override
    public Rental returnCar(Rental rental) {
        // Perform any necessary business logic before saving
        return rentalRepository.save(rental);
    }

    @Override
    public void deleteRental(int id) {
        rentalRepository.deleteById(id);
    }
}
