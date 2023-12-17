package com.eddy.Car_Rental_Management_System.service;

import com.eddy.Car_Rental_Management_System.model.Available;
import com.eddy.Car_Rental_Management_System.model.Car;
import com.eddy.Car_Rental_Management_System.model.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CarService {

    Car registerCar(MultipartFile file, String plateNumber, String model, String year, Available available, Customer customer);
    Car updateCar(Car car);
    void deleteCar(Car car);
    List<Car> carList();


//    Car findCarByPlateNumber(Car car);
// Method to find a car by its plate number
    Car findCarByPlateNumber(int plateNumber);

    List<Car> getAllCars();
}
