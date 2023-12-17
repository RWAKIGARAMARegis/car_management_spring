package com.eddy.Car_Rental_Management_System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car Id")
    private int Id;
    @Column(name = "plate_number")
    private String plateNumber;  // Change from 'int' to 'Integer'

    private String model;
    private String year;
    @Lob
    @Column(columnDefinition = "bytea")
    private String image;
    @Enumerated(EnumType.STRING)
    @Column(name = "Status_of_car")
    private Available available;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
