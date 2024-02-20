package com.brainwork.CarRentalProject.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsDto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "car_Id")
    private String id;
    private String carCompany;

    private String carColor;
    private String carModel;
    private String carType;
    private String carImg;
    private String carOwner;
    private String numPlate;
    private String car360;
    private LocalDate regDate;
    private String insurance;
    private LocalDate insuranceValidity;
    private Integer passangerCapacity;
    private String fuelType;
    private String feature;
    private Integer totalRunning;
    private Integer charge;
    }

