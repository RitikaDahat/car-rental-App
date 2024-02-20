package com.brainwork.CarRentalProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
//    {"hotel":"","room":"","stay":0,"manageParking":"","finalCost":15000}
    @Id
    @Column(name = "hotelId")
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String room;
    private int stay;
    private String manageParking;
    private double finalCost;


}
