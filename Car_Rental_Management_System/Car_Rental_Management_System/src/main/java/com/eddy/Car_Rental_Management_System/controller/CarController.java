package com.eddy.Car_Rental_Management_System.controller;

import com.eddy.Car_Rental_Management_System.model.Available;
import com.eddy.Car_Rental_Management_System.model.Car;
import com.eddy.Car_Rental_Management_System.model.Customer;
import com.eddy.Car_Rental_Management_System.service.CarService;
import com.eddy.Car_Rental_Management_System.service.CustomerService1;
import com.eddy.Car_Rental_Management_System.service.implementation.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService1 customerService1;
    @Autowired
    private CarServiceImpl  carServiceimpl;

    @GetMapping("/display")
    public String displayPage(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "admin-dashboard";
    }
    



    @GetMapping("/edit/{plateNumber}")
    public String editCar(@PathVariable("plateNumber") int plateNumber, Model model) {
        Car car = carService.findCarByPlateNumber(plateNumber);
        model.addAttribute("car", car);
        return "edit-page"; // Replace "edit-page" with the actual name of your edit page HTML file
    }

    @GetMapping("/registration")
    public String registerCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "registration-page";
    }

    @PostMapping("/register")
    public String registerCarInDb(@RequestParam("file") MultipartFile file, @RequestParam("plateNumber") String plateNumber, @RequestParam("model") String model, @RequestParam("year") String year, @RequestParam("available") Available available, @RequestParam("customerId") Integer customerId){
        Customer customer = null; // Default to null if no customer is selected
        if (customerId != null) {
            customer = customerService1.findCustomerById(customerId); // Replace 'customerService' with your actual service
        }

        carService.registerCar(file, plateNumber, model, year, available, customer);
        return "redirect:/home";
    }



    @PostMapping("/update")
    public String updateCar(@ModelAttribute("car") Car updatedCar) {
        carService.updateCar(updatedCar);
        return "redirect:/home"; // Redirect to the home page or the display page after updating
    }

    // Endpoint for deleting a car by plate number
    @GetMapping("/delete/{plateNumber}")
    public String deleteCar(@PathVariable("plateNumber") int plateNumber) {
        Car carToDelete = carService.findCarByPlateNumber(plateNumber);
        carService.deleteCar(carToDelete);
        return "redirect:/home"; // Redirect to the home page or the display page after deleting
    }

//    @GetMapping("/products/{productId}/image")
//    public ResponseEntity<byte[]> getProductImage(@PathVariable Long productId) {
//
//        if (product != null && product.getImage() != null) {
//            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(product.getImage());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
