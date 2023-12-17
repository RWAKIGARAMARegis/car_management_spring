package com.eddy.Car_Rental_Management_System.service.implementation;

import com.eddy.Car_Rental_Management_System.model.Available;
import com.eddy.Car_Rental_Management_System.model.Car;
import com.eddy.Car_Rental_Management_System.model.Customer;
import com.eddy.Car_Rental_Management_System.repository.CarRepository;
import com.eddy.Car_Rental_Management_System.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car registerCar(MultipartFile file, String plateNumber, String model, String year, Available available, Customer customer) {
        Car car1 = new Car();
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains("..")){
            System.out.println("not a valid file");
        }
        car1.setPlateNumber(plateNumber);
        car1.setModel(model);
        car1.setYear(year);
        try{
            car1.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch (IOException e){e.printStackTrace();}
        car1.setAvailable(available);
        car1.setCustomer(customer);
        return carRepository.save(car1);
    }

    @Override
    public Car updateCar(Car car) {
        // Implement update logic, e.g., save to the database
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        // Implement delete logic, e.g., delete from the database
        carRepository.delete(car);
    }

    @Override
    public List<Car> carList() {
        // Implement logic to get the list of cars from the database
        return carRepository.findAll();
    }

    @Override
    public Car findCarByPlateNumber(int plateNumber) {
            Optional<Car> optionalCar = carRepository.findById(plateNumber);
            return optionalCar.orElse(null);
    }

//    @Override
//    public Car findCarByPlateNumber(Car car) {
//        return carRepository.findById(car.getPlateNumber()).get();
//    }

    @Override
    public List<Car> getAllCars() {
        // Implement logic to get all cars from the database
        return carRepository.findAll();
    }
}
