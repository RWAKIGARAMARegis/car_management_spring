package com.eddy.Car_Rental_Management_System.controller;

import com.eddy.Car_Rental_Management_System.model.Customer;
import com.eddy.Car_Rental_Management_System.model.Type;
import com.eddy.Car_Rental_Management_System.service.CustomerService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService1 customerService1;

    @GetMapping("/index")
    public String welcomepage(Model model) {
        return "index-page";
    }
    @GetMapping("/contact")
    public String contactuspage(Model model) {
        return "contact-page";
    }

    @GetMapping("/about")
    public String Aboutuspage(Model model) {
        return "about-page";
    }

    @GetMapping("/signup")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new Customer());
        return "signup-page";
    }
    @GetMapping("/customer-dashboard")
    public String getCustomerDashboard(Model model) {
        // You can add any necessary logic or attributes for the admin dashboard
        model.addAttribute("userlogin", "Customer"); // Example: Set the username for the admin
        return "customer-dashboard";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new Customer());
        return "login-page";
    }
    @GetMapping("display")
    public String displayPage(Model model) {
        // Retrieve the list of registered customers
        List<Customer> customers = customerService1.getAllCustomers();
        // Add the list to the model
        model.addAttribute("customers", customers);
        // Return the name of your Thymeleaf template
        return "admin-dashboard";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Customer customer) {
        System.out.println("Register request: " + customer);

        if (customer == null || customer.getUsername() == null || customer.getPassword() == null || customer.getEmail() == null || customer.getType() == null) {
            // Handle invalid input or missing fields
            return "error_page1"; // Or redirect to an error page
        }

        // Set the correct enum value for customer type
        customer.setType(Type.Customer);
        customer.setType(Type.Admin);

        Customer registeredCustomer = customerService1.registerCustomer(customer);
        return registeredCustomer == null ? "error_page" : "redirect:/signup"; // Redirect to the signup page
    }


    @PostMapping("/login")
    public String login(@ModelAttribute Customer customer, Model model) {
        System.out.println("Login request: " + customer);

        if (customer == null || customer.getUsername() == null || customer.getPassword() == null) {
            // Handle invalid input or missing fields
            return "error_page1";
        }

        Customer authenticated = customerService1.authenticate(customer);

        if (authenticated != null) {
            System.out.println("Authenticated user type: " + authenticated.getType());

            model.addAttribute("userlogin", authenticated.getUsername());

            if (Type.Admin.equals(authenticated.getType())) {
                return "admin-dashboard";  // Redirect to the admin dashboard
            } else if (Type.Customer.equals(authenticated.getType())) {
                return "customer-dashboard";  // Redirect to the customer dashboard
            } else {
                return "error_page";  // Handle unknown user type
            }
        } else {
            return "error_page";
        }
    }



    @GetMapping("/admin-dashboard")
    public String getAdminDashboard(Model model) {
        // You can add any necessary logic or attributes for the admin dashboard
        model.addAttribute("userlogin", "Admin"); // Example: Set the username for the admin
        return "admin-dashboard";
    }


}