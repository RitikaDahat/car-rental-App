package com.brainwork.CarRentalProject.repositeries;

import com.brainwork.CarRentalProject.entities.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDetailsRepo extends JpaRepository<CardDetails,String> {
}
