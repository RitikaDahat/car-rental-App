package com.brainwork.CarRentalProject.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    @Id
    @Column(name = "hotelId")
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String room;
    private int stay;
    private String manageParking;
    private double finalCost;
}
