package com.brainwork.CarRentalProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "card_details")
public class CardDetails {
    @Id
//    @Column(name = "atmId")
    private String cardNo;

    private String cardHolder;

    private LocalDate expDate;

    @Transient
    private Integer cvv;

}
