package com.brainwork.CarRentalProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalConfirm {
    @Id
    private String Id;
    private String email;
    private String fname;
    private String lname;

    private String driverImg;
    private String driverName;
    private Long driverMobNo;
    private double charges;

    private String hotel;
    private String room;
    private int stay;
    private String manageParking;
    private double finalCost;
    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carImg;
    private String fuelType;
    private String pickUpLocation;
    private String dropLocation;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate dropDate;
    private int passengerCapacity;
    private String members;
    private int days;
    private long cardNo;
}
