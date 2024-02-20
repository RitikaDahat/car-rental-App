package com.brainwork.CarRentalProject.repositeries;

import com.brainwork.CarRentalProject.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,String> {
}
