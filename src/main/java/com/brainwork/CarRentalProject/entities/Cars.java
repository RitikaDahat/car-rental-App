
package com.brainwork.CarRentalProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cars {
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

    @OneToMany(mappedBy = "cars",cascade = CascadeType.ALL)
    private List<Booking> booking;
}
