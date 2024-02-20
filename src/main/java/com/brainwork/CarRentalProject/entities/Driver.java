package com.brainwork.CarRentalProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
////    @Column(name = "driverId")
//    @GeneratedValue(strategy = GenerationType.UUID)
     private String id;
//    @Column(name = "driver_Img")
     private String driverImg;

//    @Column(name = "driver_Name")
    private String driverName;

//    @Column(name = "driver_Exp")
    private String drivingExperiance;

//    @Column(name = "driver_MobNo")
    private  String driverMobNo;

    private String availability;

    private String food;

    private String drink;

    private String smoke;

    private String charges;


}
