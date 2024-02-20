package com.brainwork.CarRentalProject.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
