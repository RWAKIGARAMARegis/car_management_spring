package com.eddy.Car_Rental_Management_System.controller;

import com.eddy.Car_Rental_Management_System.model.Rental;
import com.eddy.Car_Rental_Management_System.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/list")
    public String listRentals(Model model) {
        List<Rental> rentals = rentalService.getAllRentals();
        model.addAttribute("rentals", rentals);
        return "rental/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Rental rental = new Rental();
        model.addAttribute("rental", rental);
        return "rental/add";
    }

    @PostMapping("/add")
    public String addRental(@ModelAttribute("rental") Rental rental) {
        rentalService.rentCar(rental);
        return "redirect:/rentals/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Rental rental = rentalService.getRentalById(id);
        model.addAttribute("rental", rental);
        return "rental/edit";
    }

    @PostMapping("/edit")
    public String editRental(@ModelAttribute("rental") Rental rental) {
        rentalService.returnCar(rental);
        return "redirect:/rentals/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteRental(@PathVariable("id") int id) {
        rentalService.deleteRental(id);
        return "redirect:/rentals/list";
    }
}
